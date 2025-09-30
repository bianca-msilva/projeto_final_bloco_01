package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Itens;
import projeto_final_bloco_01.repository.ItensRepository;

public class ItensController implements ItensRepository{

	private List<Itens> listaItens = new ArrayList<Itens>();
	static int numId = 0;
	
	@Override
	public void cadastrarItem(Itens item) {
		listaItens.add(item);
		System.out.println("🎉 Item cadastrado com sucesso! 🎉");
	}

	@Override
	public void listarItens() {
		for(var item : listaItens) {
			item.visualizar();
		}
		
	}

	@Override
	public void buscarItemPorId(int numId) {
		var item = buscarNaCollection(numId);
		
		if(item != null) {
			item.visualizar();
		}else {
			System.out.printf("\nA Conta número: %d não foi encontrada%n", numId);
		}
		
	}

	@Override
	public void atualizar(Itens id) {
		var buscarItem = buscarNaCollection(id.getId());
		
		if(buscarItem != null) {
			listaItens.set(listaItens.indexOf(buscarItem), id);
			System.out.printf("\nA Conta número: %d foi atualizada com sucesso%n", id.getId());
		}else {
			System.out.printf("\nA Conta número: %d não foi encontrada%n", id.getId());
		}
		
	}

	@Override
	public void apagarItem(int numId) {
		var item = buscarNaCollection(numId); 
		
		if(item != null) {
			if(listaItens.remove(item)) {
				System.out.printf("\nO Item número: %d foi deletado com sucesso!%n", numId);
			}
		}else {
			System.out.printf("\nO Item número: %d não foi encontrado%n", numId);
		}
		
	}
	
	public Itens buscarNaCollection(int numId) {
		for(var item : listaItens) {
			if(item.getId() == numId) {
				return item;
			}
		}
		return null;
	}
	
	public static int gerarId() {
		return ++numId;
	}

}
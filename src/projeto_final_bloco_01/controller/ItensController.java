package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Itens;
import projeto_final_bloco_01.repository.ItensRepository;

public class ItensController implements ItensRepository{

	private List<Itens> listaItens = new ArrayList<Itens>();
	private List<Itens> listaBodyCare = new ArrayList<Itens>();
	private List<Itens> listaSkinCare = new ArrayList<Itens>();
	private List<Itens> listaMaquiagens = new ArrayList<Itens>();
	static int numId = 0;
	
	@Override
	public void cadastrarItem(Itens item) {
		
		switch(item.getTipo()) {
			case 1 -> {
			listaBodyCare.add(item);
			listaItens.add(item);
			System.out.println("🎉 Item cadastrado com sucesso! 🎉");
			}
			case 2 -> {
				listaSkinCare.add(item);
				listaItens.add(item);
				System.out.println("🎉 Item cadastrado com sucesso! 🎉");
			}
			case 3 -> {
				listaMaquiagens.add(item);
				listaItens.add(item);
				System.out.println("🎉 Item cadastrado com sucesso! 🎉");
			}
			default -> System.out.println("Tipo inexistente!");
		}
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

	public void listarPorCategoria(int categoria) {

		switch(categoria) {
			case 1 -> {
			for(var item : listaBodyCare) {
				item.visualizar();
				}
			}
			case 2 -> {
				for(var item : listaSkinCare) {
					item.visualizar();
				}
			}
			case 3 -> {
				for(var item : listaMaquiagens) {
					item.visualizar();
				}
			}
			default -> System.out.println("Categoria inexistente! ");
		}
		
	}


}
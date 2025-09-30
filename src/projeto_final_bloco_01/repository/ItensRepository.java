package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Itens;

public interface ItensRepository {
	
	// Métodos CRUD
	public void cadastrarItem(Itens item);
	public void listarItens();
	public void buscarItemPorId(int id);
	public void atualizar(Itens id);
	public void apagarItem(int id);
	
	// Métodos específicos
	public void listarPorCategoria(int categoria);
}

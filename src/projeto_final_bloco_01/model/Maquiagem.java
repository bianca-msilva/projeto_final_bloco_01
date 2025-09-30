package projeto_final_bloco_01.model;

public class Maquiagem extends Itens{
	
	private String categoria;
	
	public Maquiagem(int id, float preco, String nome, int tipo, String categoria) {
		super(id, preco, nome, tipo);
		this.categoria = categoria;
		
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Categoria pertencente do Item (Base | Blus | Pó | Batons | Corretivos | Paletas): " + this.categoria);
	}
}

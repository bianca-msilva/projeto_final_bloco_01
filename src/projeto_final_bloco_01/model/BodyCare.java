package projeto_final_bloco_01.model;

public class BodyCare extends Itens {
	private String fragancia;
	private String categoria;
	
	public BodyCare(int id, float preco, String nome, int tipo, String fragancia, String categoria) {
		super(id, preco, nome, tipo);
		this.fragancia = fragancia;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}


	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Fragancia do Item: " + this.fragancia);
		System.out.println("Categoria pertencente do Item (Hidratante | Limpeza | Tratamento): " + this.categoria);
	}
}

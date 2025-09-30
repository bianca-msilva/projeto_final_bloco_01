package projeto_final_bloco_01.model;

public class SkinCare extends Itens{
	private String necessidade;
	private String ativos;
	private String categoria;
	
	public SkinCare(int id, float preco, String nome, int tipo, String categoria, String necessidade, String ativos) {
		super(id, preco, nome, tipo);
		this.categoria = categoria;
		this.necessidade = necessidade;
		this.ativos = ativos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNecessidade() {
		return necessidade;
	}

	public void setNecessidade(String necessidade) {
		this.necessidade = necessidade;
	}

	public String getAtivos() {
		return ativos;
	}

	public void setAtivos(String ativos) {
		this.ativos = ativos;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Necessidade atendida: " + this.necessidade);
		System.out.println("Ativos do Item: " + this.ativos);
		System.out.println("Categoria pertencente do Item (Hidratante | Limpeza | Tratamento): " + this.categoria);
	}
}

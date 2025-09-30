package projeto_final_bloco_01.model;

public abstract class Itens {
	
	// Atributos gerais dos Itens
	private int id;
	private float preco;
	private String nome;
	private int tipo;
	
	
	public Itens(int id, float preco, String nome, int tipo) {
		super();
		this.id = id;
		this.preco = preco;
		this.nome = nome;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void visualizar() {
		
		String tipo = "";
		
		switch(this.tipo) {
		case 1 -> tipo = "Itens Cuidados Corpo";
		case 2 -> tipo = "Itens Cuidados Rosto";
		case 3 -> tipo = "Maquiagens";
		default -> tipo = "Desconhecido";
		}
		System.out.println("\n***********************************************************************************");
		System.out.println("                                                                                   ");
		System.out.println("Dados do Item: ");
		System.out.println("ID do Item: " + this.id);
		System.out.println("Nome do Item: " + this.nome);
		System.out.println("Tipo do Item: " + this.tipo);
		System.out.println("Preço do Item: R$" + this.preco);
		
	}
	
}

package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ItensController;
import projeto_final_bloco_01.model.BodyCare;
import projeto_final_bloco_01.model.Itens;
import projeto_final_bloco_01.model.Maquiagem;
import projeto_final_bloco_01.model.SkinCare;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	private static final Scanner input = new Scanner(System.in);
	private static final ItensController itensController = new ItensController();
	
	public static void main(String[] args) {
		
		int opcao;
		
		SkinCare novoItem = new SkinCare(123, 50.00f, "Azelan", 2, "Tratamento", "Pele acneica", "ácido azelaico\nhidratante");
		novoItem.visualizar();
		
		BodyCare novoItem2 = new BodyCare(456, 71.00f, "Sérum corporal", 1, "Flores", "Hidratante");
		novoItem2.visualizar();
		
		Maquiagem novaMake = new Maquiagem(789, 100.00f, "Base facial 3 em 1", 3, "Base");
		novaMake.visualizar();
		
		criarItensTeste();
		
		while(true) {
		System.out.println(Cores.TEXT_CYAN_BOLD +"___________________________________________________");
		System.out.println("                                                   ");
		System.out.println("   Carevelle - Cuidado transformado em confiança   ");
		System.out.println("                                                   ");
		System.out.println("              1 - Cadastrar Item                   ");
		System.out.println("              2 - Listar todos Itens               ");
		System.out.println("              3 - Buscar Item por ID               ");
		System.out.println("              4 - Atualizar Dados do Item          ");
		System.out.println("              5 - Apagar Item                      ");
		System.out.println("              6 - Listar Itens por Categoria       ");
		System.out.println("              0 - Sair                             ");
		System.out.println("                                                   ");
		System.out.println("___________________________________________________");
		System.out.println("                                                   " + Cores.TEXT_RESET);
		System.out.print(Cores.TEXT_CYAN_BOLD + " Escolha a opção desejada: " + Cores.TEXT_RESET);
		
		try {
			opcao = input.nextInt();
			input.nextLine();
		}catch(InputMismatchException e) {
			opcao = -1; 
			System.out.println("\nDigite um número inteiro entre 0 e 9");
			input.nextLine();
		}
		
		if(opcao == 0) {
			System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n     Carevelle sempre ao seu lado!     " + Cores.TEXT_RESET);
			sobre();
			input.close();
			System.exit(0);
			
		}
		
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Cadastrar Item     "+ Cores.TEXT_RESET);
				cadastrarItem();
				keyPress();
				break;
				
			case 2:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Listar todos Itens     "+ Cores.TEXT_RESET);
				listarItens();
				keyPress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Buscar Item por ID     "+ Cores.TEXT_RESET);
				buscarItemPorID();
				keyPress();
				break;
			
			case 4:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Atualizar Item     "+ Cores.TEXT_RESET);
				atualizarItem();
				keyPress();
				break;
			
			case 5:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Apagar Item     "+ Cores.TEXT_RESET);
				apagarItem();
				keyPress();
				break;
			
			case 6:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Listar Itens por Categoria    "+ Cores.TEXT_RESET);
				listarPorCategoria();
				keyPress();
				break;	
			
			default: 
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção Inválida     "+ Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
		
	}
	
	public static void sobre() {
		System.out.println("___________________________________________________");
		System.out.println("                                                   ");
		System.out.println("Sistema desenvolvido por: Bianca Maria"
				+ "\nContatos:"
				+ "\nGitHub: https://github.com/bianca-msilva"
				+ "\nE-mail: BiancaSi@genstudents.org");
		System.out.println("                                                   ");
		System.out.println("___________________________________________________");
	}

	private static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\n Pressione Enter para continuar... ");
		input.nextLine();
	}
	
	public static void criarItensTeste() {
		itensController.cadastrarItem(new BodyCare(ItensController.gerarId(), 71.00f, "Sérum corporal", 1, "Flores", "Hidratante"));
		itensController.cadastrarItem(new SkinCare(ItensController.gerarId(), 50.00f, "Azelan", 2, "Tratamento", "Pele acneica", "Ácido azelaico e Hidratante"));
		itensController.cadastrarItem(new Maquiagem(ItensController.gerarId(), 50.00f, "Contorno facial", 3, "Pele"));
	}
	
	private static void listarItens() {
		itensController.listarItens();
	}
	
	private static void cadastrarItem() {
		System.out.print("\nDigite o Nome do Item: ");
		String nome = input.nextLine(); 
		
		System.out.print("Digite o Preço do Item: ");
		Float preco = input.nextFloat(); 

		System.out.print("Digite o Tipo do Item: ");
		int tipo = input.nextInt();
		input.nextLine(); 

		switch (tipo) {
		    case 1 -> {
		        System.out.print("Digite Fragrância do Item: ");
		        String fragancia = input.nextLine();

		        System.out.print("Digite a qual Categoria pertence o Item (Hidratante | Limpeza | Tratamento): ");
		        String categoria = input.nextLine();

		        itensController.cadastrarItem(new BodyCare(ItensController.gerarId(), preco, nome, tipo, fragancia, categoria));
		    }
		case 2 -> {
			System.out.print("Digite qual Necessidade atendida pelo Item: ");
			String necessidade = input.nextLine();			
			
			System.out.print("Digite os Ativos do Item, separados por vírgula: ");
			String ativos = input.nextLine();			
			
			System.out.print("Digite a qual Categoria pertence o Item (Hidratante | Limpeza | Tratamento): ");
			String categoriaSkin = input.nextLine();
			
			itensController.cadastrarItem(new SkinCare(ItensController.gerarId(), preco, nome, tipo, necessidade, ativos, categoriaSkin));
		}
		case 3 -> {
			System.out.print("Digite a qual Categoria pertence o Item (Olhos | Pele | Boca): ");
			String categoriaMake = input.nextLine();
			
			itensController.cadastrarItem(new Maquiagem(ItensController.gerarId(), preco, nome, tipo, categoriaMake));
		}
		default -> System.out.print(Cores.TEXT_RED + "Opção inválida!" + Cores.TEXT_RESET);
		}
		
	}
	
	private static void buscarItemPorID() {
		System.out.print("Digite o número do Item: ");
		int numID = input.nextInt();
		input.nextLine();
		
		itensController.buscarItemPorId(numID);
	}
	
	private static void atualizarItem() {
		System.out.print("Digite o número do Item a ser atualizado: ");
		int numID = input.nextInt();
		input.nextLine();
		
		Itens item = itensController.buscarNaCollection(numID);
		
		if(item != null) {
			
			String nome = item.getNome();
			float preco = item.getPreco();
			int tipo = item.getTipo();
			
			System.out.printf("Nome atual do Item: %s \nNome atualizado (Pressione ENTER para manter o valor atual): ", nome);
			String entrada = input.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;
			
			System.out.printf("Preço atual do Item: %f \nPreço atualizado (Pressione ENTER para manter o valor atual): ", preco);
			entrada = input.nextLine();
			preco = entrada.isEmpty() ? preco : Integer.parseInt(entrada);
			
			switch(tipo) {
			case 1 -> {
				String fragancia = ((BodyCare) item).getFragancia();
				String categoria = ((BodyCare) item).getCategoria();
				
				System.out.printf("A Fragância atual é: %s \nNova Fragância (Pressione ENTER para manter a atual): ", fragancia);
				entrada = input.nextLine();
				fragancia = entrada.isEmpty() ? fragancia : entrada;
				
				System.out.printf("A Categoria atual é: %s \nNova Categoria (Pressione ENTER para manter a atual): ", categoria);
				entrada = input.nextLine();
				categoria = entrada.isEmpty() ? categoria : entrada;
				
				itensController.atualizar(new BodyCare(numID, preco, nome, tipo, fragancia, categoria));
				
			}
			case 2 -> {
				String necessidade = ((SkinCare) item).getNecessidade();
				String ativos = ((SkinCare) item).getAtivos();
				String categoriaSkin = ((SkinCare) item).getCategoria();
				
				System.out.printf("A(s) Necessidade(s) atendida(s) atual(is) é(são): %s \nNova(s) Necessidade(s) atendida(s) (Pressione ENTER para manter a atual): ", necessidade);
				entrada = input.nextLine();
				necessidade = entrada.isEmpty() ? necessidade : entrada;
				
				System.out.printf("O(s) Ativo(s) atual(is) é(são): %s \nNovo(s) Ativos(s) (Pressione ENTER para manter a atual): ", ativos);
				entrada = input.nextLine();
				ativos = entrada.isEmpty() ? ativos : entrada;			
				
				System.out.printf("O Categoria atual é: %s \nNova Categoria (Pressione ENTER para manter a atual): ", categoriaSkin);
				entrada = input.nextLine();
				categoriaSkin = entrada.isEmpty() ? categoriaSkin : entrada;	
				
				itensController.atualizar(new SkinCare(numID, preco, nome, tipo, necessidade, categoriaSkin, ativos));
			}
			
			case 3 -> {
				String categoriaMake = ((Maquiagem) item).getCategoria();
				
				System.out.printf("O Categoria atual é: %s \nNova Categoria (Pressione ENTER para manter a atual): ", categoriaMake);
				entrada = input.nextLine();
				categoriaMake = entrada.isEmpty() ? categoriaMake : entrada;
				
				itensController.atualizar(new Maquiagem(numID, preco, nome, tipo, categoriaMake));
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de Item inválido!" + Cores.TEXT_RESET);
			}
			
			
			
		}else {
			System.out.printf("\nA conta número %d não foi encontrada!", numID);
		}
	}
	
	
	private static void apagarItem() {
		System.out.print("Digite o número do Item a ser deletado: ");
		int numID = input.nextInt();
		input.nextLine();
		
		Itens item = itensController.buscarNaCollection(numID);
		
		if(item != null) {
			System.out.println("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String resposta = input.nextLine();
			
			if(resposta.equalsIgnoreCase("S")) {
				itensController.apagarItem(numID);
			}else {
				System.out.print("\nOperação cancelada!");
			}
		}else {
			System.out.printf("\nA conta número %d não foi encontrada!", numID);
		}
	}
	
	private static void listarPorCategoria() {
	    System.out.println("1 - BodyCare");
	    System.out.println("2 - SkinCare");
	    System.out.println("3 - Maquiagens");
	    System.out.print("Escolha a categoria: ");
	    int categoria = input.nextInt();
	    input.nextLine();
	    itensController.listarPorCategoria(categoria);
    }
		
}

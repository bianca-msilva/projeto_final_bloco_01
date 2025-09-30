package projeto_final_bloco_01;

import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;

public class Menu {

	private static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		int opcao;
		
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
		System.out.println("              0 - Sair                             ");
		System.out.println("                                                   ");
		System.out.println("___________________________________________________");
		System.out.println("                                                   " + Cores.TEXT_RESET);
		System.out.print(Cores.TEXT_CYAN_BOLD + "   Escolha a opção desejada: " + Cores.TEXT_RESET);
		opcao = input.nextInt();
		input.nextLine();
		
		if(opcao == 0) {
			System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n     Carevelle sempre ao seu lado!     ");
			sobre();
			input.close();
			System.exit(0);
			
		}
		
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Cadastrar Item     ");
				keyPress();
				break;
				
			case 2:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Listar todos Itens     ");
				keyPress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Buscar Item por ID     ");
				keyPress();
				break;
			
			case 4:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Atualizar Item     ");
				keyPress();
				break;
			
			case 5:
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção - Apagar Item     ");
				keyPress();
				break;
			
			default: 
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n      Opção Inválida     ");
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

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\n   Pressione Enter para continuar... ");
		input.nextLine();
	}
}

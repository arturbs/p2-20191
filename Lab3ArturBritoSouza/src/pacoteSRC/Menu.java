package pacoteSRC; /**
 * Representacao de algo( mudar)!!!
 *
 * @author Artur Brito Souza
 */

/**
 *  Representa o menu de interação com o usuário da pacoteSRC.Agenda
 */

import java.util.Scanner;

public class Menu {

    /**
     *  Representa o Menu de interacao.
     *  
     * @author Artur Brito Souza
     */
	
	public static void exibeMenu () {
		
		String opcao = "";
		Agenda agenda = new Agenda();
		
	
	    while (!opcao.equals("S")) {
	    	
	        System.out.println("(C)adastrar");

	        System.out.println("(L)istar Contatos");

	        System.out.println("(E)xibir");

	        System.out.println("(S)air");

	        System.out.print("Opcao> ");

	        opcao = new Scanner (System.in).nextLine().toUpperCase();

            if (opcao.equals("C")){
            	
                System.out.print("Posicao: ");
                int posicao = new Scanner (System.in).nextInt();

                System.out.print("Nome: ");
                String nome = new Scanner (System.in).nextLine();

                System.out.print("Sobrenome: ");
                String sobreNome = new Scanner (System.in).nextLine();

                System.out.print("Telefone: ");
                String telefone = new Scanner (System.in).nextLine();

                agenda.cadastraContatos(posicao, nome, sobreNome, telefone);

                System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
            }

            if (opcao.equals("L")){
            	System.out.println(agenda.listaDeContatos());
            	

            }

            if (opcao.equals("E")){
            	System.out.print("Contato> ");
            	int posicaoProcurada = new Scanner (System.in).nextInt();
            	System.out.println(agenda.encontraContato(posicaoProcurada) + System.lineSeparator());

            }
            
            if (!opcao.equals("S") && !opcao.equals("C") && !opcao.equals("L") && !opcao.equals("E") ) {
            	 System.out.println("OPCAO INVALIDA!" + System.lineSeparator());
            	
            }
        }
	    System.out.println("Programa finalizado");
	}

}

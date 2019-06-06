package pacoteSCR;
import java.util.Scanner;

/**
 * Criado para exibir o menu de interação com o usuário
 * @author Artur Brito Souza - 118210056 - UFCG
 */

public class Menu {
    private static String escolha;
    private static String opcoes;
    private static Controlador controlador;


    /**
     * Exibição do menu.
     */
    public static void exibeMenu(){
        Scanner sc = new Scanner(System.in);
        controlador = new Controlador();
        escolha = "";

        opcoes = "(C)adastrar Aluno" +  System.lineSeparator()
                + "(E)xibir Aluno" +  System.lineSeparator()
                + "(N)ovo Grupo" +  System.lineSeparator()
                + "(A)locar Aluno no Grupo e Imprimir Grupos" +  System.lineSeparator()
                + "(R)egistrar Aluno que Respondeu" +  System.lineSeparator()
                + "(I)mprimir Alunos que Responderam" +  System.lineSeparator()
                + "(O)ra, vamos fechar o programa!" +  System.lineSeparator();

        

        while (!escolha.equals("O")){
        	
            System.out.println(opcoes);
            
            System.out.print("Opcao> ");
            Scanner saida;
            escolha = new Scanner (System.in).nextLine().toUpperCase();

            if (escolha.equals("C")){
            	
            	System.lineSeparator();

                System.out.print("Matricula: ");
                String matricula = new Scanner(System.in).nextLine();

                System.out.print("Nome: ");
                String nome = new Scanner(System.in).nextLine();

                System.out.print("Curso: ");
                String curso = new Scanner(System.in).nextLine();

                if (controlador.cadastraAluno(matricula, nome, curso)){
                    System.out.println("CADASTRO REALIZADO!" + System.lineSeparator() ); 
                }
                else {
                    System.out.println("MATRICULA JA CADASTRADA!" + System.lineSeparator() );
                }

            }

            if (escolha.equals("E")){
            	
            	System.out.print("Matricula: ");
            	String matricula = new Scanner(System.in).nextLine();
            	System.lineSeparator();
            	
            	System.out.println(controlador.consultarAluno(matricula));
            	System.lineSeparator();
            }
            
            if (escolha.equals("N")) {
            	
            	System.out.print("Grupo: ");
            	String nome = new Scanner(System.in).nextLine();
            	
            	if (controlador.cadastraGrupo(nome)) {
            		System.out.println("CADASTRO REALIZADO!" + System.lineSeparator() ); 
            	}
            	
            	else {
            		System.out.println("GRUPO JA CADASTRADO!" + System.lineSeparator() );  		
            	}
            }
            
            if (escolha.equals("A")) {
            	System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
            	String escolha = new Scanner (System.in).nextLine().toUpperCase();
            	
            	if (escolha.equals("A")) {
            		System.out.print("Matricula: ");
            		String matricula = new Scanner(System.in).nextLine();
            		
            		System.out.print("Grupo: ");
            		String nome = new Scanner(System.in).nextLine();
            		
            		System.out.println(controlador.alocacaoDeAlunos(matricula, nome));
            	}
            	if (escolha.equals("I")) {
            		System.out.print("Grupo: ");
            		String nome = new Scanner(System.in).nextLine();
            		
            		
            	}
            	
            	
            }
            
            if (escolha.equals("R")) {
            	
            	System.out.print("Matricula: ");
            	String matricula = new Scanner(System.in).nextLine();
            	
            	if (controlador.cadastraAlunoQueRespondeu(matricula)) {
            		System.out.println("ALUNO REGISTRADO!");
            		System.lineSeparator();
            	}
            	else {
            		System.out.println("ALUNO NAO CADASTRADO!");
            		System.lineSeparator();
            	}
            }
            
            if (escolha.equals("I")) {
            	
            	System.out.println(controlador.imprimiOsAlunosQueResponderam());
            	System.lineSeparator();
            }
          
        }
    }
}


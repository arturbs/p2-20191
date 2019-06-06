package pacoteSCR;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Representação do controlador.
 *
 * Cada controlador possui um grupo de alunos (cada aluno é unicamente identifcado pela matrícula), 
 * um conjunto de grupos (Identificados pelo tema, o qual é único e não é dependente de caracteres especiais ou do tamanho das letras) 
 * e um grupo de alunos que vão ao quadro responder questões (podendo cada aluno ir mais de uma vez)
 * @author Artur Brito Souza - 118210056 - UFCG
 */

public class Controlador {
	
	/**
     * Mapa de alunos, identificados unicamente pela matrícula.
     */
    private HashMap <String, Aluno> alunos;
    
    /**
     * Mapa de grupos, identificados unicamente pelo tema do grupo.
     */
    private HashMap <String, Grupo> grupos;
    
    /**
     * Lista de alunos que vão ao quadro responder as questões.
     */
    private ArrayList <String> alunosQueResponderam;
    
    /**
     * Constroi um Controlador. Inicializa o mapa de alunos, grupos e a lista de alunos que vão responder questões no quadro.
     */
    public Controlador() {
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.alunosQueResponderam = new ArrayList<>();
    }
    
    /**
     * Criado para cadastrar alunos no Sistema. Cada aluno possui uma matrícula (que o torna único), um nome e um curso
     *
     * @param matricula String representando a matrícula do aluno (identificador único).
     * @param nome String representando o nome do aluno.
     * @param curso Stringg representando o curso do aluno.
     * @return true caso o cadastro aluno seja concluido ou false caso haja a tentiva de cadastrar um aluno com uma matrícula ja existente.
     */
    public boolean cadastraAluno (String matricula, String nome, String curso) {
        if (alunos.containsKey(matricula)){
            return false;
        }
        else {
            Aluno a = new Aluno(matricula, nome, curso);
            alunos.put(matricula, a);
            return true;
        }
    }

    /**
     * Criado para consultar um aluno através da matrícula.
     *
     * @param matricula String representando a matricula do aluno.
     * @return Saida String, sendo saida as informações do aluno escolhido, caso o aluno esteja cadastrado ou
     * a frase Aluno nao cadastrado, caso o aluno nao esteja cadastrado.  
     */
    public String consultarAluno (String matricula){
    	
    	String saida = "";
    	
        if (alunos.containsKey(matricula)){
            saida = alunos.get(matricula).toString() ;
        }
        
        else {
        	saida = "Aluno nao cadastrado ";
        	
        }

        return saida;
    }
    
    /**
     * Criado para cadastrar um grupo no sistema. Cada grupo é representado pelo seu nome, 
     * que representa o tema que o grupo tratará (que é único)
     * @param nome String representando o nome do grupo.
     * @return true caso o cadastro do grupo seja concluuido e false caso haja
     * a tentiva de cadastrar um grupo com um nome ja existente.
     */
    public boolean cadastraGrupo(String nome) {
    	if (!this.grupos.containsKey(nome.toLowerCase())) {
    		Grupo g = this.grupos.put(nome.toLowerCase(), new Grupo (nome));
    		return true;
    	}
    	
    	else {
    		return false;
    	}	
	}
    
    /**
     * Criado para alocar um aluno (que já deve estar previamente cadastrado) em um grupo (que já deve estar previamente cadastrado).
     *
     * @param matricula String que representa o aluno que deve ser cadastrado.
     * @param nome String representando o grupo ao qual o aluno deve ser cadastrado.
     * @return String saida, que e "ALUNO ALOCADO!" Caso o alocamento do aluno seja concluido ou 
     * String "Grupo não cadastrado!" caso o grupo que tenha sido tentado alocar o aluno não esteja cadastrado ou
     *  "Aluno não cadastrado!" caso exista a tentativa de alocar um aluno que ainda não foi cadastrado.
     */
    public String alocacaoDeAlunos(String matricula, String nome) {
    	String saida = "";
    	
    	if (nome.trim().equals("") || matricula.trim().equals("")) {
            throw new IllegalArgumentException("");
        }
    	
    	if (nome == null || matricula == null) {
    		throw new NullPointerException();
    	}
    	if (!this.grupos.containsKey(nome.toLowerCase()) && !this.alunos.containsKey(matricula)) {
    		saida += "GRUPO NAO CADASTRADO!" + System.lineSeparator();
    		saida += "ALUNO NAO CADASTRADO!" + System.lineSeparator();
    	}
    	
    	if (!this.grupos.containsKey(nome.toLowerCase())) {
    		saida += "GRUPO NAO CADASTRADO!" + System.lineSeparator();
    	}
    	
    	if (!this.alunos.containsKey(matricula)) {
    		saida += "ALUNO NAO CADASTRADO!" + System.lineSeparator();
    	}
    	
    	else {
    		this.grupos.get(nome.toLowerCase()).alocaAluno(this.alunos.get(matricula));
    		saida += "ALUNO ALOCADO";
    	}
    	return saida;
    }
    
    //public boolean imprimeOsAlunosDoGrupo (String nome) {
    	
    	//if(nome.trim().equals("")) {
    		 //throw new IllegalArgumentException("");	
    	//}
    	//if (nome == null) {
    	//	throw new NullPointerException();
    	//}
    	
    	
   // }
    	
    
/**
 * Criado para cadastrar alunos que fazem questões no quadro.
 *
 * @param matricula String representando o aluno que vai fazer questões no quadro.
 * @return true caso o registro ocorra sem problemas e false caso tentarem registra uma matricula que não está cadastrada no sistema.
 */
    public boolean cadastraAlunoQueRespondeu (String matricula) {
    	
    	if (alunos.containsKey(matricula)) {
    		alunosQueResponderam.add(alunos.get(matricula).informacoesDoAluno());
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    /**
     * Criado para imprimir todos os alunos registrados que fizeram questões no quadro.
     *
     * @return String representando a lista de alunos registrados que fizeram questões no quadro. No padrão:
     * 1. matricula - nome - curso
     * 2. matricula - nome - curso
     * ...
     * n. matricula - nome - curso
     */
    public String imprimiOsAlunosQueResponderam () {
    	
    	String saida = "";
    	
    	saida += "Alunos: ";
    	saida += System.lineSeparator();
    	for (int i = 0; i < alunosQueResponderam.size(); i++) {
    		saida += i+1 + ". " + alunosQueResponderam.get(i) + System.lineSeparator();
    		
    	}
    	
    	return saida;
    }
}

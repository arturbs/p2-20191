package pacoteSCR;
import java.util.Objects;

/**
 * Classe criada para representar um Aluno
 *
 * Cada aluno possui uma matrícula (que é o único identificador do aluno), um nome e uma matrícula
 * @author Artur Brito Souza - 118210056 - UFCG
 */

public class Aluno {
	
	/**
     * Matrícula do Aluno
     * Identificador único do aluno
     */
    private String matricula;
    
    /**
     * Nome do Aluno
     */
    private String nome;
    
    /**
     * Curso do Aluno
     */
    private String curso;


    /**
     * Constroi o objeto Aluno
     *
     * @param matricula String representando a matrícula do aluno. Cada matrícula é única.
     * @param nome String representando o nome do aluno.
     * @param curso String representando o curso do aluno.
     */
    public Aluno (String matricula, String nome, String curso){
    	
    	if (matricula.trim().equals("") || nome.trim().equals("") || curso.trim().equals("")) {
    		throw new IllegalArgumentException("");
    	}
    	
    	if (matricula == null || nome == null || curso == null) {
    		throw new NullPointerException();
    	 }
    	 
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Retorna a matricula.
     */
    public String getMatricula() {
        return matricula;
    }
    

    /**
     * Um aluno é igual ao outro quando ambos possuem a mesma matrícula. Tornando assim, a matrícula o identificador único do aluno.
     *
     * @return boolean true, para quando os alunos são iguais (possuem a mesma matrícula) e false para quando os alunos são diferentes 
     * (possuem matrículas diferentes).
     */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

	/**
     * HashCode geral a partir do número de matrícula
     *
     * @return um inteiro representando o hashcode do objeto Aluno. HashCode baseado na matrícula do aluno.
     */

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    /**
     * Representando em forma de String do Aluno
     *
     * @return retorna uma String no padrão:
     *  Aluno: matricula - nome - curso
     */
    @Override
    public String toString() {
        return "Aluno: " + matricula + " - " + nome + " - " + curso ;
    }
    
    /**
     * Representando em forma de String de informações do aluno
     *
     * @return retorna uma String no padrão:
     *  matricula - nome - curso
     */
    public String informacoesDoAluno() {
    	return  matricula + " - " + nome + " - " + curso ;
    }
}

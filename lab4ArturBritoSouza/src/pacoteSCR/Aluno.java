package pacoteSCR;
import java.util.Objects;

/**
 * Classe criada para representar um Aluno
 *
 * Cada aluno possui uma matr�cula (que � o �nico identificador do aluno), um nome e uma matr�cula
 * @author Artur Brito Souza - 118210056 - UFCG
 */

public class Aluno {
	
	/**
     * Matr�cula do Aluno
     * Identificador �nico do aluno
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
     * @param matricula String representando a matr�cula do aluno. Cada matr�cula � �nica.
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
     * Um aluno � igual ao outro quando ambos possuem a mesma matr�cula. Tornando assim, a matr�cula o identificador �nico do aluno.
     *
     * @return boolean true, para quando os alunos s�o iguais (possuem a mesma matr�cula) e false para quando os alunos s�o diferentes 
     * (possuem matr�culas diferentes).
     */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

	/**
     * HashCode geral a partir do n�mero de matr�cula
     *
     * @return um inteiro representando o hashcode do objeto Aluno. HashCode baseado na matr�cula do aluno.
     */

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    /**
     * Representando em forma de String do Aluno
     *
     * @return retorna uma String no padr�o:
     *  Aluno: matricula - nome - curso
     */
    @Override
    public String toString() {
        return "Aluno: " + matricula + " - " + nome + " - " + curso ;
    }
    
    /**
     * Representando em forma de String de informa��es do aluno
     *
     * @return retorna uma String no padr�o:
     *  matricula - nome - curso
     */
    public String informacoesDoAluno() {
    	return  matricula + " - " + nome + " - " + curso ;
    }
}

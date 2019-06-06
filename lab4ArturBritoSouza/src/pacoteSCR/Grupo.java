package pacoteSCR;
import java.util.HashSet;
/**
 * Representa��o de um Grupo
 * Cada grupo possui um nome (que � seu identificador) e um conjunto de alunos que fazem parte desse grupo.
 *
 * @author Artur Brito Souza - 118210056 - UFCG
 */
public class Grupo {
	/**
     * String representando o nome do grupo (Identificador �nico)
     */
	private String nome;
	
	/**
     * Conjunto de alunos
     */
	private HashSet <Aluno> alunosDoGrupo;
	
	/**
     * Constroi o objeto grupo.
     * @param nome String representando o nome do Grupo (Identificador �nico)
     */
	public Grupo (String nome) {
		if (nome.trim().equals("")) {
            throw  new IllegalArgumentException("");
        }
		if (nome == null) {
			throw new NullPointerException();
		}
		
		this.nome = nome;
		this.alunosDoGrupo = new HashSet<>();
	}

	/**
     * Retorna o nome.
     */
	public String getNome() {
		return nome;
	}
	
	/**
     * Criado para alocar um aluno no conjunto de alunos do grupo.
     * @param aluno Objeto Aluno representando o aluno que vai ser alocado no conjunto.
     * @return true quando a aloca��o for bem sucedida.
     */
	public boolean alocaAluno(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException();
		}
		
		this.alunosDoGrupo.add(aluno);
		return true;
	}

	/**
     * HashCode gerado a partir do nome do grupo.
     * @return int representando hashcode do objeto grupo.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
     * Um grupo � igual ao outro quando o seu nome � igual ao nome de outro grupo, 
     * ignorando letras maiusculas e minusculas.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
			return false;
		return true;
	}
}

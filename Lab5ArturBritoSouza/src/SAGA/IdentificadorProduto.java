package SAGA;

/**
 * Classe criada para Representar um identificador do Produto, que sera usado como identificador unico do produto
 * Um identificadorProduto e formado a partir do nome e a descricao do produto.
 *
 * @author Artur Brito Souza - UFCG 
 */
public class IdentificadorProduto {
	
	
	/**
     * Representacao do nome do produto.
     */
	private String nome;
	
	/**
     * Representacao da descricao do produto.
     */
	private String descricao;

	/**
     * Constroi um identificador do Produto
     *
     * @param nome Representacao do nome do produto.
     * @param descricao Representacao da descricao do produto.
     */
	public IdentificadorProduto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	/**
     * hashCde Baseado no nome e na descricao.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
     * Equals baseado do nome e na descricao.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentificadorProduto other = (IdentificadorProduto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}

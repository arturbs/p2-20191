package SAGA.ProdutosEDerivados;

/**
 * Classe criada para Representar um identificador do Produto, que sera usado como identificador unico do produto
 * Um identificadorProduto e formado a partir do nome e a descricao do produto.
 *
 * @author Artur Brito Souza - UFCG 
 */
public class IdentificadorProdutoECombo {
	
	
	/**
     * Representacao do nome que sera usado para formar o id.
     */
	private String nome;
	
	/**
     * Representacao da descricao que sera usado para formar o id.
     */
	private String descricao;

	/**
     * Constroi um identificador (para o produto ou combo).
     *
     * @param nome Representacao do nome que sera usado para formar o id.
     * @param descricao Representacao da descricao que sera usado para formar o id.
     */
	public IdentificadorProdutoECombo(String nome, String descricao) {
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
		IdentificadorProdutoECombo other = (IdentificadorProdutoECombo) obj;
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

	@Override
	public String toString() {
		return "IdentificadorProdutoECombo{" +
				"nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				'}';
	}
}

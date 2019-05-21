package SAGA;
import java.util.Objects;

/**
 * Classe criada para Representar um Produto do Fornecedor.
 * Um Produto do Fornecedor e representado por um Nome, descricao e preco. O mesmo e
 * identificado unicamente pelo seu id, que e gerado a partir do seu nome e sua descricao.
 *
 * @author Artur Brito Souza - UFCG 
 */
public class ProdutoDoFornecedor implements Comparable<ProdutoDoFornecedor>{

	/**
     * Representacao do Nome do Produto do Fornecedor
     */
    private String nome;
    
    /**
     * Representacao do preco do Produto do Fornecedor
     */
    private double preco;
    
    /**
     * Representacao da descricao do Produto do Fornecedor
     */
    private String descricao;

    /**
     * Constroi um Produto do Fornecedor
     *
     * @param nome Representacao do nome do Produto do Fornecedor
     * @param descricao Representacao da descricao do Produto do Fornecedor
     * @param preco Representacao do preco do Produto do Fornecedor
     */
    public ProdutoDoFornecedor(String nome, String descricao, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }


    /**
     * Criado para retornar o nome do Produto do Fornecedor
     * @return String com o nome do Produto do Fornecedor
     */
    public String getNome() {
        return nome;
    }

    /**
     * Criado para retornar a descricao do Produto do Fornecedor
     * @return String com a descricao do Produto do Fornecedor
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Criado para alterar o atributo preco do Produto do Fornecedor
     * @param String com o novo preco do Produto do Fornecedor
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Equals Baseado no nome e na descricao do Produto do Fornecedor
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDoFornecedor that = (ProdutoDoFornecedor) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao);
    }

    /**
     * Hashcode Baseado no nome e na descricao do Produto do Fornecedor
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**
     * Representacao Textual do Produto do Fornecedor
     * @return String no formato "nome - descricao - R$preco"
     */
    @Override
    public String toString() {
        return nome + " - " + descricao + " - R$" + String.format("%.2f", preco);
    }

    /**
     * Comparador baseado no nome do Produto
     */
    @Override
    public int compareTo(ProdutoDoFornecedor o) {
        return this.nome.compareTo(o.getNome());
    }
}
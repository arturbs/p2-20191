package SAGA;
import java.util.Objects;

/**
 * Classe criada para Representar um Produto do Fornecedor.
 * Um Produto do Fornecedor � representado por um Nome, descri��o e pre�o. O mesmo �
 * identificado unicamente pelo seu id, que � gerado a partir do seu nome e sua descri��o.
 *
 * @author Artur Brito Souza - UFCG 
 */
public class ProdutoDoFornecedor {

	/**
     * Representa��o do Nome do Produto do Fornecedor 
     */
    private String nome;
    
    /**
     * Representa��o do pre�o do Produto do Fornecedor 
     */
    private double preco;
    
    /**
     * Representa��o da descri��o do Produto do Fornecedor 
     */
    private String descricao;

    /**
     * Constroi um Produto do Fornecedor
     *
     * @param nome Representa��o do nome do Produto do Fornecedor
     * @param descricao Representa��o da descri��o do Produto do Fornecedor
     * @param preco Representa��o do pre�o do Produto do Fornecedor
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
     * @param String com o novo pre�o do Produto do Fornecedor
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
     * Representa��o Textual do Produto do Fornecedor
     * @return String no formato "nome - descri�ao - R$pre�o"
     */
    @Override
    public String toString() {
        return nome + " - " + descricao + " - R$" + preco;
    }
}
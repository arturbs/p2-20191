package SAGA;
import java.util.Objects;

/**
 * Classe criada para Representar um Produto do Fornecedor.
 * Um Produto do Fornecedor é representado por um Nome, descrição e preço. O mesmo é
 * identificado unicamente pelo seu id, que é gerado a partir do seu nome e sua descrição.
 *
 * @author Artur Brito Souza - UFCG 
 */
public class ProdutoDoFornecedor {

	/**
     * Representação do Nome do Produto do Fornecedor 
     */
    private String nome;
    
    /**
     * Representação do preço do Produto do Fornecedor 
     */
    private double preco;
    
    /**
     * Representação da descrição do Produto do Fornecedor 
     */
    private String descricao;

    /**
     * Constroi um Produto do Fornecedor
     *
     * @param nome Representação do nome do Produto do Fornecedor
     * @param descricao Representação da descrição do Produto do Fornecedor
     * @param preco Representação do preço do Produto do Fornecedor
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
     * @param String com o novo preço do Produto do Fornecedor
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
     * Representação Textual do Produto do Fornecedor
     * @return String no formato "nome - descriçao - R$preço"
     */
    @Override
    public String toString() {
        return nome + " - " + descricao + " - R$" + preco;
    }
}
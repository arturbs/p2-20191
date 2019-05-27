package SAGA.ProdutosEDerivados;
import java.util.Objects;

/**
 * Classe criada para Representar um Produto abstract do Fornecedor,
 * sendo molde para suas duas classes filhas, produto e combo.
 * Um Produto abstract do Fornecedor e representado por um Nome,
 * descricao e por um boolean para saber se ele e combo ou produto . O mesmo e
 * identificado unicamente pelo seu id, que e gerado a partir do seu nome e sua descricao.
 *
 * @author Artur Brito Souza - UFCG 
 */
public abstract class ProdutoDoFornecedorAbstract implements Comparable<ProdutoDoFornecedorAbstract>{

	/**
     * Representacao do Nome do Produto abstract do Fornecedor
     */
    protected String nome;
    
    /**
     * Representacao da variavel que verifica se e combo ou produto.
     */
    protected boolean combo;
    
    /**
     * Representacao da descricao do Produto abstract do Fornecedor
     */
    protected String descricao;

    /**
     * base para a construcao de produto e combo.
     *
     * @param nome Representacao do nome do Produto abstract do Fornecedor
     * @param descricao Representacao da descricao do Produto abstract do Fornecedor
     * @param combo Representacao da variavel qe verifica se e combo ou produto.
     */
    public ProdutoDoFornecedorAbstract(String nome, String descricao, boolean combo) {
        this.nome = nome;
        this.descricao = descricao;
        this.combo = combo;
    }

    public abstract double getPreco();

    public abstract void alteraValor(double novoValor);

    /**
     * Criado para retornar o nome do Produto abstract do Fornecedor
     * @return String com o nome do Produto abstractdo Fornecedor
     */
    public String getNome() { return nome; }

    /**
     * Criado para retornar a descricao do Produto abstract do Fornecedor
     * @return String com a descricao do Produto abstract do Fornecedor
     */
    public String getDescricao() { return descricao; }

    /**
     * Criado para retornar um boolean om a afirmacao se e combo ou nao.
     * @return boolean com a afirmacao.
     */
    public boolean isCombo() {
        return combo;
    }

    /**
     * Equals Baseado no nome e na descricao do Produto abstract do Fornecedor
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDoFornecedorAbstract that = (ProdutoDoFornecedorAbstract) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao);
    }

    /**
     * Hashcode Baseado no nome e na descricao do Produto abstract do Fornecedor
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**
     * Representacao Textual do Produto abstract do Fornecedor
     * @return String no formato "nome - descricao - R$preco"
     */
    @Override
    public String toString() {
        return nome + " - " + descricao + " - R$" + String.format("%.2f", this.getPreco());
    }

    /**
     * Comparador baseado no nome do Produto abstract
     */
    @Override
    public int compareTo(ProdutoDoFornecedorAbstract o) {
        return this.nome.compareTo(o.getNome());
    }
}
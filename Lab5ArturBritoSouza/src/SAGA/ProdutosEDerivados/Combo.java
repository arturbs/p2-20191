package SAGA.ProdutosEDerivados;

import java.util.Set;

/**
 * Classe criada para Representar um combo
 * Um combo é representado por um nome, descricao, um fator e um
 * conjunto de produtos. O mesmo e identificado unicamente pelo seu id,
 * que e gerado a partir do seu nome e sua descricao.
 *
 * @author Artur Brito Souza - UFCG
 */
public class Combo extends ProdutoDoFornecedorAbstract {

    private Set<ProdutoDoFornecedorAbstract> produtos;
    private double fator;

    /**
     * Constroi um Produto do Fornecedor
     *
     * @param nome Representacao do nome do Produto do Fornecedor
     * @param descricao Representacao da descricao do Produto do Fornecedor
     * @param combo representacao se e combo ou nao.
     * @param fator representacao do fator do combo, que representa o desconto sobre os produto que formam o combo.
     * @param produtos representacao dos produtos que irao formar o combo.
     */
    public Combo(String nome, String descricao, boolean combo, double fator, Set<ProdutoDoFornecedorAbstract> produtos) {
        super(nome, descricao, combo);
        this.fator = fator;
        this.produtos = produtos;
    }


    @Override
    public double getPreco() {
        double somaPreco = 0.0;
        for (ProdutoDoFornecedorAbstract produto : this.produtos) {
            somaPreco += produto.getPreco();
        }
        return somaPreco * (1 - this.fator);
    }

    @Override
    public void alteraValor(double novoFator) {
        this.fator = novoFator;
    }
}

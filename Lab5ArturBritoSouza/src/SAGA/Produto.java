package SAGA;

public class Produto extends ProdutoDoFornecedorAbstract {

    private double preco;

    /**
     * Constroi um Produto do Fornecedor
     *
     * @param nome      Representacao do nome do Produto do Fornecedor
     * @param descricao Representacao da descricao do Produto do Fornecedor
     * @param combo
     */
    public Produto(String nome, String descricao, boolean combo, double preco) {
        super(nome, descricao, combo);
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    public void alteraValor(double novoPreco) {
        this.preco = novoPreco;
    }
}

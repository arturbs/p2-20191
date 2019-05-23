package SAGA;

import java.util.Set;

public class Combo extends ProdutoDoFornecedorAbstract {

    private Set<ProdutoDoFornecedorAbstract> produtos;
    private double fator;

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

package SAGA.Conta;

import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;

public class Compra {


    private String data;

    private String produto;

    private double preco;

    public Compra(String data, String produto, double preco) {
        this.data = data;
        this.produto = produto;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}

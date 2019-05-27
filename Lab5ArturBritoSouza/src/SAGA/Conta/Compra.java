package SAGA.Conta;

import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;

public class Compra {


    private String data;

    private IdentificadorProdutoECombo id;

    private double preco;

    public Compra(String data, IdentificadorProdutoECombo id, double preco) {
        this.data = data;
        this.id = id;
        this.preco = preco;
    }
}

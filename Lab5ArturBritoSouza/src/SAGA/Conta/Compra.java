package SAGA.Conta;

import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;

public class Compra {

    private String data;

    private String nomeProduto;

    private String descricaoProduto;

    private double preco;

    public Compra(String data, String nomeProduto, String descricaoProduto, double preco) {
        this.data = data;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nomeProduto + " - " + data;
    }
}

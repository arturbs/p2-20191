package SAGA.Conta;

import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;

import java.util.ArrayList;
import java.util.Objects;

public class Conta {


    private String nomeFornecedor;

    private double debito;

    private ArrayList<Compra> listaDeCompras;


    public Conta(String nomeFornecedor, String nomeCliente) {
        this.nomeFornecedor = nomeFornecedor;
        this.debito = 0;
        this.listaDeCompras = new ArrayList<>();
    }

    public double getDebito(){
        return debito;
    }

    public void cadastraCompra (String fornecedor, String data, String nomeProd, String descProd, double preco){
        Compra c = new Compra(data, nomeProd, descProd, preco );
        this.listaDeCompras.add(c);
        this.debito += preco;

    }

    @Override
    public String toString() {
        return nomeFornecedor + " | " + listaDeCompras.toString();
    }
}

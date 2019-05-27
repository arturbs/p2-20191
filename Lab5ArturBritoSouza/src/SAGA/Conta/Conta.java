package SAGA.Conta;

import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;

import java.util.ArrayList;
import java.util.Objects;

public class Conta {


    private String nomeFornecedor;

    private String nomeCliente;

    private double debito;

    public Conta(String nomeFornecedor, String nomeCliente) {
        this.nomeFornecedor = nomeFornecedor;
        this.nomeCliente = nomeCliente;
        this.debito = 0;
    }
}

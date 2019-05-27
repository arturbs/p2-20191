package SAGA.Conta;

import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;

import java.util.ArrayList;
import java.util.Objects;

public class Conta {

    private String cpf;

    private String nomeCliente;

    private String nomeFornecedor;

    private double debito;

    private ArrayList<Compra> compras;


    public Conta (String cpf, String nomeFornecedor, String nomeCliente){


        this.cpf = cpf;
        this.debito = 0;
        this.nomeFornecedor = nomeFornecedor;
        this.nomeCliente = nomeCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return cpf.equals(conta.cpf) &&
                nomeFornecedor.equals(conta.nomeFornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nomeFornecedor);
    }

    public void cadastraCompra (String data, String produto, double preco){
        Compra compra = new Compra(data, produto,preco);
        compras.add(compra);
        System.out.println(compras);
    }

    public double getDebito(){
        double debitoTotal = 0;

        for (Compra listaDeCompras: this.compras){
            debitoTotal += listaDeCompras.getPreco();
        }
        return debitoTotal;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente + " | " + nomeFornecedor + " | " + compras;
    }
}

package SAGA.Conta;

import java.util.HashMap;

public class ControllerConta {


    private HashMap<IdentificadorConta , Conta> contas;

    public ControllerConta() {
        this.contas = new HashMap<>();
    }


    public String cadastraCompra(String cpf, String fornecedor, String data, String nome_prod, double preco) {
        IdentificadorConta  id = new IdentificadorConta(cpf.toLowerCase(), fornecedor.toLowerCase());

        if (!contas.containsKey(id)){

        }
        String saida = "";
        return saida;




        //return this.clientes.get(cpf).compra

    }

    public String mostraDebito(String cpf, String fornecedor){
        String saida = "";

        return saida;
    }
}

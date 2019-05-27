package SAGA.Conta;

import java.util.HashMap;

public class ControllerConta {


    private HashMap<IdentificadorConta , Conta> contas;

    public ControllerConta() {
        this.contas = new HashMap<>();
    }


    public void cadastraCompra(String cpf, String fornecedor, String data, String nome_prod, double preco) {
        IdentificadorConta  id = new IdentificadorConta(cpf.toLowerCase(), fornecedor.toLowerCase());

        if (!contas.containsKey(id)){

            Conta c = new Conta(cpf, fornecedor);
            contas.put(id, c);
        }
        System.out.println(contas);
        contas.get(id).cadastraCompra(data, nome_prod, preco);

    }

    public double mostraDebito(String cpf, String fornecedor){
        IdentificadorConta  id = new IdentificadorConta(cpf.toLowerCase(), fornecedor.toLowerCase());

        return contas.get(id).getDebito();
    }
}

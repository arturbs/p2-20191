package SAGA;

import SAGA.Cliente.ControllerCliente;
import SAGA.Conta.ControllerConta;
import SAGA.Fornecedor.ControllerFornecedor;
import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;

public class SAGAController {

    ControllerCliente clientes;
    ControllerFornecedor fornecedores;
    ControllerConta contas;

    public SAGAController() {
        this.clientes = new ControllerCliente();
        this.fornecedores = new ControllerFornecedor();
        this.contas = new ControllerConta();
    }
    //Cliente
    public String adicionaCliente(String cpf, String nome, String email, String localizacao){
        return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf) {
        return this.clientes.encontraCliente(cpf);
    }

    public String exibeClientes (){
        return this.clientes.listaClientes();
    }

    public String editaCliente (String cpf, String atributo, String novoValor){
        return this.clientes.editaCadastro(cpf, atributo, novoValor);
    }

    public String removeCliente(String cpf){
        return this.clientes.RemoveClienteDoCadastro(cpf);
    }


    //Fornecedor
    public String adicionaFornecedor(String nome, String email, String telefone){
        return this.fornecedores.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor ( String nome){
        return this.fornecedores.encontraFornecedor(nome);
    }

    public  String exibeFornecedores(){
        return this.fornecedores.listarFornecedores();
    }

    public String editaFornecedor (String nome, String atributo, String novoValor){
        return this.fornecedores.editaFornecedor(nome, atributo, novoValor);
    }

    public String removeFornecedor(String nome) {
        return this.fornecedores.removeFornecedor(nome);
    }

    //Produto
    public  void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
        this.fornecedores.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
    }

    public String exibeProduto  (String nomeProduto, String descricao, String nomeFornecedor) {
        return this.fornecedores.encontraProduto(nomeProduto, descricao, nomeFornecedor);
    }

    public String exibeProdutosFornecedor (String nome) {
        return this.fornecedores.listaProdutosFornecedor(nome);
    }

    public String exibeProdutos (){
        return this.fornecedores.listarProdutosDeTodosOsFornecedores();
    }

    public String editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoPreco) {
        return this.fornecedores.editaProduto(nomeProduto, descricao, nomeFornecedor, novoPreco);
    }

    public String removeProduto (String nomeProduto, String descricao, String nomeFornecedor) {
        return this.fornecedores.removeProduto(nomeProduto, descricao, nomeFornecedor);
    }

    //Combo
    public void adicionaCombo(String Fornecedor, String nome, String descricao, double fator, String produtos){
        this.fornecedores.cadastraCombo(Fornecedor, nome, descricao, fator, produtos);

    }

    public String editaCombo(String nome, String descricao, String Fornecedor, double novoFator) {
        return this.fornecedores.editaCombo(nome, descricao, Fornecedor, novoFator);
    }

    //Compras

    public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod){

        util.Validador.validaStringNullEVazia(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
        util.Validador.validaTamanhoString(cpf, 11, 11, "Erro ao cadastrar compra: cpf invalido.");
        util.Validador.validaStringNullEVazia(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        util.Validador.validaTamanhoString(data, 10, 10, "Erro ao cadastrar compra: data invalida.");
        if (!this.clientes.getClientes().containsKey(cpf)) {
            throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
        }
        util.Validador.validaStringNullEVazia(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        if(!this.fornecedores.getFornecedores().containsKey(fornecedor)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
        }
        util.Validador.validaStringNullEVazia(nome_prod, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        util.Validador.validaStringNullEVazia(desc_prod, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
        IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome_prod.toLowerCase(), desc_prod.toLowerCase());
        if (!this.fornecedores.getListaDeProdutos(fornecedor).containsKey(id)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
        }


    }

    public double getDebito(String cpf, String fornecedor){

        util.Validador.validaStringNullEVazia(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");

        util.Validador.validaTamanhoString(cpf, 11, 11, "Erro ao recuperar debito: cpf invalido.");
        if (!this.clientes.getClientes().containsKey(cpf)) {
            throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
        }
        util.Validador.validaStringNullEVazia(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
        if(!this.fornecedores.getFornecedores().containsKey(fornecedor)){
            throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
        }
        return 0;
    }

    public String exibeContas(String cpf, String fornecedor) {
        util.Validador.validaStringNullEVazia(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
        util.Validador.validaTamanhoString(cpf, 11, 11, "Erro ao exibir conta do cliente: cpf invalido.");
        if (!this.clientes.getClientes().containsKey(cpf)) {
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
        }
        util.Validador.validaStringNullEVazia(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
        if(!this.fornecedores.getFornecedores().containsKey(fornecedor)){
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
        }
        return "o";
    }

    public String exibeContasClientes (String cpf){
        util.Validador.validaStringNullEVazia(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
        util.Validador.validaTamanhoString(cpf, 11, 11, "Erro ao exibir contas do cliente: cpf invalido.");
        if (!this.clientes.getClientes().containsKey(cpf)) {
            throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
        }
        return "o";
    }

}

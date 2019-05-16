package SAGA;

import SAGA.ControllerCliente;
import SAGA.ControllerFornecedor;
import easyaccept.EasyAccept;

public class Facade {
	
	ControllerCliente clientes;
	ControllerFornecedor fornecedores;
	
	public Facade() {
		this.clientes = new ControllerCliente();
		this.fornecedores = new ControllerFornecedor();
	}
	
	public static void main(String[] args) {
		args = new String[] { "SAGA.Facade", "acceptance_test/use_case_1.txt",
				"acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt",
				};
		EasyAccept.main(args);
	}
		
	public String adicionaCliente(String cpf, String nome, String email, String localizacao){
		return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.clientes.encontraCliente(cpf);
	}
	
	public String listaClientes (){
		return this.clientes.listaClientes();
	}
	
	public String editaCliente (String cpf, String atributo, String novoValor){
		return this.clientes.editaCadastro(cpf, atributo, novoValor);
	}
	
	public String removeCliente(String cpf){
		return this.clientes.RemoveClienteDoCadastro(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone){
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor ( String nome){
		return this.fornecedores.encontraFornecedor(nome);
	}
	
	public  String listarFornecedores(){
		return this.fornecedores.listarFornecedores();
	}
	
	public String editaFornecedor (String nome, String atributo, String novoValor){
		return this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	public String removeFornecedor(String nome) {
		return this.fornecedores.removeFornecedor(nome);
	}
	
	public  void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		this.fornecedores.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}
	
	public String exibeProduto  (String nomeProduto, String descricao, String nomeFornecedor) {
		return this.fornecedores.encontraProduto(nomeProduto, descricao, nomeFornecedor);
	}
	
	public String listaProdutosFornecedor (String nome) {
		return this.fornecedores.listaProdutosFornecedor(nome);
	}
	
	public String editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoPreco) {
		return this.fornecedores.editaProduto(nomeProduto, descricao, nomeFornecedor, novoPreco);
	}
	
	public String removeProduto (String nomeProduto, String descricao, String nomeFornecedor) {
		return this.fornecedores.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	//public String adicionaCombo(String nomeFornecedor, nomeCombo, descricaoCombo, fator, nomeProduto1, nomeProduto2){
	//	return this.fornecedores.cadastraCombo(nomeFornecedor, nomeCombo, descricaoCombo, fator, nomeProduto1, nomeProduto2);

	//}
		
}
	


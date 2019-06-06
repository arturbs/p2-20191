package SAGA;

import SAGA.Cliente.ControllerCliente;
import SAGA.Fornecedor.ControllerFornecedor;
import easyaccept.EasyAccept;

public class Facade {
	

	private SAGAController controladorPrincipal;

	public Facade() {
		this.controladorPrincipal = new SAGAController();

	}
	
	public static void main(String[] args) {
		args = new String[] { "SAGA.Facade", "acceptance_test/use_case_1.txt",
				"acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt",
				"acceptance_test/use_case_5.txt", "acceptance_test/use_case_6.txt",
				"acceptance_test/use_case_7.txt", "acceptance_test/use_case_8.txt",
				};
		EasyAccept.main(args);
	}

	//Cliente
	public String adicionaCliente(String cpf, String nome, String email, String localizacao){
		return this.controladorPrincipal.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.controladorPrincipal.exibeCliente(cpf);
	}
	
	public String exibeClientes (){
		return this.controladorPrincipal.exibeClientes();
	}
	
	public void editaCliente (String cpf, String atributo, String novoValor){
		this.controladorPrincipal.editaCliente(cpf, atributo, novoValor);
	}
	
	public String removeCliente(String cpf){
		return this.controladorPrincipal.removeCliente(cpf);
	}


	//Fornecedor
	public String adicionaFornecedor(String nome, String email, String telefone){
		return this.controladorPrincipal.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor ( String nome){
		return this.controladorPrincipal.exibeFornecedor(nome);
	}
	
	public  String exibeFornecedores(){
		return this.controladorPrincipal.exibeFornecedores();
	}
	
	public String editaFornecedor (String nome, String atributo, String novoValor){
		return this.controladorPrincipal.editaFornecedor(nome, atributo, novoValor);
	}
	
	public String removeFornecedor(String nome) {
		return this.controladorPrincipal.removeFornecedor(nome);
	}

	//Produto
	public  void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		this.controladorPrincipal.adicionaProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}
	
	public String exibeProduto  (String nomeProduto, String descricao, String nomeFornecedor) {
		return this.controladorPrincipal.exibeProduto(nomeProduto, descricao, nomeFornecedor);
	}
	
	public String exibeProdutosFornecedor (String nome) {
		return this.controladorPrincipal.exibeProdutosFornecedor(nome);
	}

	public String exibeProdutos (){
		return this.controladorPrincipal.exibeProdutos();
	}
	
	public String editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoPreco) {
		return this.controladorPrincipal.editaProduto(nomeProduto, descricao, nomeFornecedor, novoPreco);
	}
	
	public String removeProduto (String nomeProduto, String descricao, String nomeFornecedor) {
		return this.controladorPrincipal.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	//Combo
	public void adicionaCombo(String Fornecedor, String nome, String descricao, double fator, String produtos){
		this.controladorPrincipal.adicionaCombo(Fornecedor, nome, descricao, fator, produtos);

	}

    public String editaCombo(String nome, String descricao, String Fornecedor, double novoFator) {
        return this.controladorPrincipal.editaCombo(nome, descricao, Fornecedor, novoFator);
    }

	//Compras
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		this.controladorPrincipal.adicionaCompra(cpf, fornecedor, data, nome_prod, desc_prod);
	}

	public double getDebito (String cpf, String fornecedor) {
		return this.controladorPrincipal.getDebito(cpf, fornecedor);
	}

	public String exibeContas(String cpf, String fornecedor){
		return this.controladorPrincipal.exibeContas(cpf, fornecedor);
	}

	public String exibeContasClientes (String cpf){
		return this.controladorPrincipal.exibeContasClientes(cpf);
	}

	//Pagamento
	public void realizaPagamento(String cpf, String fornecedor){
		this.controladorPrincipal.pagamento(cpf, fornecedor);
	}


}
	


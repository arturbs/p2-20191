package SAGA;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Criado para controlar a classe Fornecedor
 * Um Controller Fornecedor possui um Conjunto de fornecedores, que possuem como chave o nome do fornecedor.
 * 
 * @author Artur Brito Souza - UFCG 
 */
public class ControllerFornecedor {

	/**
     * Conjunto de fornecedores, identificados unicamente pelo seu nome, que tambem e a chave do mapa fornecedores
     */
    private HashMap<String, Fornecedor> fornecedores;



    /**
     * Criado para inicializar o ControllerFornecedor
     */
    public  ControllerFornecedor(){
        this.fornecedores = new HashMap<>();
    }


    /**
     * Criado para adicionar um fornecedor ao controlador
     *
     * @param nome String com nome do fornecedor.
     * @param email String com email do fornecedor.
     * @param telefone String com o numero de telefone do fornecedor.
     * @return String com cpf do cliente cadastrado.
     */
    public String cadastraFornecedor(String nome, String email, String telefone){
    	if (nome.trim().equals("") || nome == null ) {
    		throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
    	}

		if (email.trim().equals("") || email == null ) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}

    	if (telefone.trim().equals("") || telefone == null ) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
    	
        if (this.fornecedores.containsKey(nome)){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }

        Fornecedor f = new Fornecedor(nome, email, telefone);
        this.fornecedores.put(nome, f);
        return nome;
    }

    /**
     * Criado para retornar a representacao de um fornecedor especifico.
     *
     * @param nome String com nome do fornecedor que deseja ser encontrado.
     * @return String com representacao do fornecedor desejado, ou frase fornecedor nao cadastrado, caso o fornecedor nao esteja no sistema.
     */
    public String encontraFornecedor ( String nome){
        String saida = "";

        if (this.fornecedores.containsKey(nome)){
            saida = this.fornecedores.get(nome).toString();
        }

        else{
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

        return saida;
    }

    /**
     * Criado para retornar a representacao de todos os fornecedores
     *
     * @return String com nome de todos os fornecedores cadastrados
     */
    public  String listarFornecedores(){
        String saida = "";


		List <Fornecedor> fornecedorList = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedorList);

		for (Fornecedor fornecedor : fornecedorList){

			saida += fornecedor.toString() + " | ";

		}

		return saida.substring(0, saida.length() - 3);
    }

    /**
     * Criado para editar algum atributo do fornecedor
     *
     * @param nome que ira identificar o cliente
     * @param informacao qual o atributo que sera modificado
     * @param alteracao novo valor o qual o atributo indicado sera substitituido.
     * @return String com a frase Altercao concluida
     */
    public String editaFornecedor (String nome, String informacao, String alteracao){

    	if (informacao.trim().equals("nome")){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
    	if (informacao == null || informacao.trim().equals("")){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
    	}

    	if (!informacao.toLowerCase().trim().equals("email") && !informacao.toLowerCase().trim().equals("telefone") && !informacao.toLowerCase().trim().equals("nome")) {
    		throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
    	}
    	if (alteracao == null || alteracao.trim().equals("")){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
    	}
    	if (!this.fornecedores.containsKey(nome)) {
    		throw new IllegalArgumentException("Erro na alteracao do fornecedor: fornecedor nao cadastrado");
    	}
        if (this.fornecedores.containsKey(nome)){
            if (informacao.toLowerCase().equals("email")){
            	this.fornecedores.get(nome).setEmail(alteracao);
            }
            if (informacao.toLowerCase().equals("telefone")){
            	this.fornecedores.get(nome).setTelefone(alteracao);
            }
        }
        return "Altercao concluida";
    }

    /**
     * Criado para remove algum fornecedor.
     *
     * @param nome String com nome do fornecedor que sera removido.
     * @return String com a frase fornecedor removido.
     */
    public String removeFornecedor(String nome){
        String saida = "";

        if (nome.trim().equals("") || nome == null ){
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}

        if (this.fornecedores.containsKey(nome)){
        	this.fornecedores.remove(nome);
            saida = "Fornecedor removido";
        }
        return  saida;
    }
  
    /**
     * Criado para cadastrar um produto em um fornecedor
     * 
     * @param nomeProduto String com o nome do produto
     * @param descricao String com a descricao do produto
     * @param preco double com o preco do produto
     * @param nomeFornecedor String com o nome do fornecedor
     * @return boolean true se o cadastro obter sucesso.
     */
    public void cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco){

		if (nomeProduto.trim().equals("") || nomeProduto == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao.trim().equals("") || descricao == null ) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if (nomeFornecedor.trim().equals("") || nomeFornecedor == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if (!fornecedores.containsKey(nomeFornecedor)){
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}

		fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricao, preco);
    }
    
    
    /**
     * Criado para retornar a representacao de um produto especifico
     *
     * @param nomeProduto String com o nome do produto desejado
     * @param descricao String com descricao do produto desejado
     * @param nomeFornecedor String com o nome do fornecedor ao qual o produto desejado pertence.
     * @return uma String com a representacao de um produto
     */
    public String encontraProduto (String nomeProduto, String descricao, String nomeFornecedor) {

		if (nomeProduto.trim().equals("") || nomeProduto == null) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao.trim().equals("") || descricao == null ) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (nomeFornecedor.trim().equals("") || nomeFornecedor == null) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!fornecedores.containsKey(nomeFornecedor)){
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
    	
    	return this.fornecedores.get(nomeFornecedor).encontraProduto(nomeProduto, descricao);
    }
    
    /**
     * Criado para retornar a representacao dos produtos de um fornecedor especifico.
     *
     * @param nome String com nome do fornecedor desejado
     * @return String com representacao dos produtos do fornecedor desejado.
     */
    public String listaProdutosFornecedor (String nome) {
    	
    	if (nome.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na listagem de produtos do fornecedor: nome n�o pode ser vazio");
    	}
    	if (nome == null) {
    		throw new NullPointerException("Erro na listagem de produtos do fornecedor: nome n�o pode ser nulo");
    	}
    	
    	return this.fornecedores.get(nome).listaProdutosFornecedor(nome);
    }
 
    /**
     * Criado para retornar a representacao dos produtos de um fornecedor especifico.
     * obs: Nao ordenada
     *

     * @return String com representacao dos produtos de todos os fornecedores cadastrados.
     */
    public String listarProdutosDeTodosOsFornecedores () {

		//String saida = "";


		//List<ProdutoDoFornecedor> produtoDoFornecedorList = new ArrayList<>(this.listaDeProdutos.values());
		//Collections.sort(produtoDoFornecedorList);

		//for (ProdutoDoFornecedor produtoDoFornecedor : produtoDoFornecedorList){

		//	saida += produtoDoFornecedor.toString() + " | ";

		//}

		//return saida.substring(0, saida.length() - 3);

		String saida = "";

    		for (int i = 0; i < this.fornecedores.size() - 1; i++){
    			saida += this.fornecedores.get(i).toString() + " | ";
    		}
    		for (int i = this.fornecedores.size(); i < this.fornecedores.size(); i++){
    			saida += this.fornecedores.get(i).toString();
    		}
    		return saida;
    }
    
    /**
     * Criado para editar algum atributo do Cliente.
     *
     * @param nome String com nome do produto que ira formar o id.
     * @param descricao String com a descricao do produto que ira formar o id.
     * @param novoPreco double que sera o novo valor do preco do produto
     * @param nomeFornecedor String com nome do fornecedor ao qual pertecence o produto que deseja-se alterar.
     * @return String com a frase Altercao concluida
     */
    
    public String editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoPreco) {
    	
    	if (nomeProduto == null || nomeProduto.trim().equals("")){
    		throw new NullPointerException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
    	}
    	if (descricao == null || descricao.trim().equals("")){
    		throw new NullPointerException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
    	}
    	if (novoPreco < 0) {
    		throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
    	}
		if (nomeFornecedor == null || nomeFornecedor.trim().equals("")){
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
    	if (!fornecedores.containsKey(nomeFornecedor)){
    		throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
    	}

    	return this.fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, novoPreco);
    	
    }
    
    /**
     * Criado para remove algum produto
     *
     * @param nomeProduto String com o nome do produto que sera removido.
     * @param descricao String com descricao do produto que sera removido.
     * @param nomeFornecedor String com o nome do fornecedor ao qual o produto pertence.
     * @return String com a frase cliente removido.
     */
    public String removeProduto (String nomeProduto, String descricao, String nomeFornecedor) {

		if (nomeProduto == null || nomeProduto.trim().equals("")){
			throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")){
			throw new NullPointerException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (nomeFornecedor == null || nomeFornecedor.trim().equals("")){
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!fornecedores.containsKey(nomeFornecedor)){
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
		}

    	return this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
    }
}

package SAGA;

import java.util.HashMap;

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
     * Criado para retornar a representa��o de todos os fornecedores
     *
     * @return String com nome de todos os fornecedores cadastrados
     */
    public  String listarFornecedores(){
        String saida = "";

        for (int i = 0; i < this.fornecedores.size() - 1; i++){
            saida += fornecedores.get(i).toString() + " | ";
        }
        for (int i = this.fornecedores.size(); i < this.fornecedores.size(); i++){
            saida += this.fornecedores.get(i).toString();
        }

        return saida;
    }

    /**
     * Criado para editar algum atributo do fornecedor
     *
     * @param nome que ir� identificar o cliente
     * @param informacao qual o atributo que ser� modificado
     * @param alteracao novo valor o qual o atributo indicado ser� substitituido.
     * @return String com a frase Altercao concluida
     */
    public String editaFornecedor (String nome, String informacao, String alteracao){

    	if (informacao == null){
    		throw new NullPointerException("Erro na altera��o do fornecedor: atributo desejado n�o pode ser nulo");
    	}
    	if (informacao.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na altera��o do fornecedor: atributo desejado n�o pode ser vazio");
    	}
    	if (!informacao.toLowerCase().trim().equals("email") || !informacao.toLowerCase().trim().equals("telefone")) {
    		throw new IllegalArgumentException("Erro na altera��o do fornecedor: atributo n�o existente");
    	}
    	if (alteracao == null){
    		throw new NullPointerException("Erro na altera��o do fornecedor: novo valor desejado n�o pode ser nulo");
    	}
    	if (alteracao.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na altera��o do fornecedor: novo valor desejado n�o pode ser vazio");
    	}
    	if (!this.fornecedores.containsKey(nome)) {
    		throw new IllegalArgumentException("Erro na altera��o do fornecedor: fornecedor n�o cadastrado");
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
     * @param nome String com nome do fornecedor que ser� removido.
     * @return String com a frase fornecedor removido.
     */
    public String removeFornecedor(String nome){
        String saida = "";

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
    public IdentificadorProduto cadastraProduto(String nomeProduto, String descricao, double preco, String nomeFornecedor){
    	
    	if (nomeProduto.trim().equals("") || descricao.trim().equals("")) {
    		throw new IllegalArgumentException("Erro no cadastro do produto: nome e/ou descri��o n�o pode ser vazio");
    	}
    	if (nomeProduto == null || descricao == null ) {
    		throw new NullPointerException("Erro no cadastro do produto: nome e/ou descri��o n�o pode ser nulo");
    	 }
    	if (preco < 0) {
    		throw new IllegalArgumentException("Erro no cadastro do produto: pre�o n�o pode ser negativo");
    	}
        return this.fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricao, preco);
    }
    
    
    /**
     * Criado para retornar a representa��o de um produto especifico
     *
     * @param nomeProduto String com o nome do produto desejado
     * @param descricao String com descricao do produto desejado
     * @param nomeFornecedor String com o nome do fornecedor ao qual o produto desejado pertence.
     * @return uma String com a representa��o de um produto
     */
    public String encontraProduto (String nomeProduto, String descricao, String nomeFornecedor) {
    	
    	if (nomeProduto.trim().equals("") || descricao.trim().equals("") || nomeFornecedor.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na remo��o do produto: nome, descri��o e/ou fornecedor n�o pode ser vazio");
    	}
    	if (nomeProduto == null || descricao == null || nomeFornecedor == null ) {
    		throw new NullPointerException("Erro na remo��o do produto: nome, descri��o e/ou fornecedor n�o pode ser nulo");
    	}
    	
    	return this.fornecedores.get(nomeFornecedor).encontraProduto(nomeProduto, descricao);
    }
    
    /**
     * Criado para retornar a representa��o dos produtos de um fornecedor especifico.
     *
     * @param nome String com nome do fornecedor desejado
     * @return String com representa��o dos produtos do fornecedor desejado.
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
     * Criado para retornar a representa��o dos produtos de um fornecedor especifico.
     * obs: N�o implementada.(implementada errada)
     *

     * @return String com representa��o dos produtos de todos os fornecedores cadastrados.
     */
    public String listarProdutosDeTodosOsFornecedores () {
    	
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
     * @param nome String com nome do produto que ir� formar o id.
     * @param descricao String com a descricao do produto que ir� formar o id.
     * @param novoPreco double que sera o novo valor do preco do produto
     * @param nomeFornecedor String com nome do fornecedor ao qual pertecence o produto que deseja-se alterar.
     * @return String com a frase Altercao concluida
     */
    
    public String editaProduto(String nomeProduto, String descricao, double novoPreco, String nomeFornecedor) {
    	
    	if (nomeProduto == null){
    		throw new NullPointerException("Erro na altera��o do produto: nome do produto n�o pode ser nulo");
    	}
    	if (nomeProduto.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na altera��o do produto: nome do produto n�o pode ser vazio");
    	}
    	if (descricao == null){
    		throw new NullPointerException("Erro na altera��o do produto: descri��o do produto n�o pode ser nulo");
    	}
    	if (descricao.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na altera��o do produto: descri��o do produto n�o pode ser vazio");
    	}
    	if (novoPreco < 0) {
    		throw new IllegalArgumentException("Erro na altera��o do produto: pre�o n�o pode ser menor que 0");
    	}
    	if (nomeFornecedor == null){
    		throw new NullPointerException("Erro na altera��o do produto: nome do fornecedor n�o pode ser nulo");
    	}
    	if (nomeFornecedor.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na altera��o do produto: nome do fornecedor n�o pode ser vazio");
    	}
    	
    	return this.fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, novoPreco);
    	
    }
    
    /**
     * Criado para remove algum produto
     *
     * @param nomeProduto String com o nome do produto que ser� removido.
     * @param descricao String com descricao do produto que ser� removido.
     * @param nomeFornecedor String com o nome do fornecedor ao qual o produto pertence.
     * @return String com a frase cliente removido.
     */
    public String removeProduto (String nomeProduto, String descricao, String nomeFornecedor) {
    	
    	if (nomeProduto.trim().equals("") || descricao.trim().equals("") || nomeFornecedor.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na remo��o do produto: nome, descri��o e/ou fornecedor n�o pode ser vazio");
    	}
    	if (nomeProduto == null || descricao == null || nomeFornecedor == null ) {
    		throw new NullPointerException("Erro na remo��o do produto: nome, descri��o e/ou fornecedor n�o pode ser nulo");
    	}
    	
    	return this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
    }
}

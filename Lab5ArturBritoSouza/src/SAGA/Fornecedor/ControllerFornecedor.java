package SAGA.Fornecedor;

import javax.rmi.CORBA.Util;
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
        util.Validador.validaStringNull(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

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

        util.Validador.validaStringNull(informacao,"Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(informacao, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(alteracao,"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(alteracao, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(nome,"Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        if (informacao.trim().equals("nome")){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
    	if (!informacao.toLowerCase().trim().equals("email") && !informacao.toLowerCase().trim().equals("telefone") && !informacao.toLowerCase().trim().equals("nome")) {
    		throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
    	}

    	if (!this.fornecedores.containsKey(nome)) {
    		throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
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

        if (nome == null || nome.trim().equals("") ){
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}

        if (!this.fornecedores.containsKey(nome)){
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
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
        util.Validador.validaStringNull(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		util.Validador.validaStringNull(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNull(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		util.Validador.validaStringVazia(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

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

        util.Validador.validaStringNull(nomeProduto,"Erro na exibicao de produto: nome nao pode ser vazio ou nulo." );
		util.Validador.validaStringVazia(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(descricao,"Erro na exibicao de produto: descricao nao pode ser vazia ou nula." );
        util.Validador.validaStringVazia(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        util.Validador.validaStringNull(nomeFornecedor,"Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo." );
        util.Validador.validaStringVazia(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");

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


        util.Validador.validaStringNull(nome,"Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo." );
        util.Validador.validaStringVazia(nome, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
    	if (!this.fornecedores.containsKey(nome)){
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
    	return this.fornecedores.get(nome).listaProdutosFornecedor();
    }
 
    /**
     * Criado para retornar a representacao dos produtos de todos fornecedor especifico.
     * obs: Nao ordenada
     *

     * @return String com representacao dos produtos de todos os fornecedores cadastrados.
     */
    public String listarProdutosDeTodosOsFornecedores () {

		String saida = "";


		List<Fornecedor> fornecedorList = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedorList);

		for (Fornecedor fornecedor : fornecedorList){

			saida +=  fornecedor.listaProdutosFornecedor()+ " | ";

		}

		return saida.substring(0, saida.length() - 3);
    }
    
    /**
     * Criado para editar algum atributo do Cliente.
     *
     * @param nomeProduto String com nome do produto que ira formar o id.
     * @param descricao String com a descricao do produto que ira formar o id.
     * @param novoPreco double que sera o novo valor do preco do produto
     * @param nomeFornecedor String com nome do fornecedor ao qual pertecence o produto que deseja-se alterar.
     * @return String com a frase Altercao concluida
     */
    
    public String editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoPreco) {

        util.Validador.validaStringNull(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        util.Validador.validaStringVazia(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");

    	if (novoPreco < 0) {
    		throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
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

        util.Validador.validaStringNull(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        util.Validador.validaStringVazia(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");

		if (!fornecedores.containsKey(nomeFornecedor)){
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
		}

    	return this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
    }

    public void cadastraCombo(String nomeFornecedor, String nomeCombo, String descricao, double fator, String produtos){
        util.Validador.validaStringNull(nomeFornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nomeFornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        util.Validador.validaStringVazia(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        util.Validador.validaStringNull(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
        util.Validador.validaStringVazia(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
        if (fator <= 0 || fator >= 1) {
            throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
        }
        if (!fornecedores.containsKey(nomeFornecedor)){
            throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
        }

        fornecedores.get(nomeFornecedor).cadastraCombo(nomeCombo, descricao, fator, produtos);
    }

    public String editaCombo(String nome, String descricao, String Fornecedor, double novoFator) {

        util.Validador.validaStringNull(Fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(Fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringVazia(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNull(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        util.Validador.validaStringVazia(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");

        if (novoFator < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }
        if (!fornecedores.containsKey(Fornecedor)){
            throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
        }

        return this.fornecedores.get(Fornecedor).editaProduto(nome, descricao, novoFator);

    }
}

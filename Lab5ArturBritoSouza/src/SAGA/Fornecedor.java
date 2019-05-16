package SAGA;

import java.util.*;

/**
 * Classe criada para Representar um Fornecedor
 * Um Cliente é representado por um nome, Email, um telefone e um
 * conjunto de produtos. O mesmo é identificado unicamente pelo nome.
 *
 * @author Artur Brito Souza - UFCG 
 */
public class Fornecedor implements Comparable<Fornecedor>{

	/**
     * Representacao do Nome do Fornecedor (Identificador Unico)
     */
    private String nome;
    
    /**
     * Representacao do email do Fornecedor,
     */
    private String email;
    
    /**
     * Representacao do numero de telefone do Fornecedor.
     */
    private String telefone;
    
    /**
     * Representacao dos produtos cadastrados pelo Fornecedor. Possui como chave o IdentificadorProduto que e uma classe que cria
     * uma identifcacao unica com base no nome e descricao do produto.
     */
    private HashMap <IdentificadorProduto, ProdutoDoFornecedor> listaDeProdutos;

	/**
	 * Representacao dos combos de produtos cadastrados pelo Fornecedor. Possui como chave o IdentificadorCombo que e uma classe que cria
	 * uma identifcacao unica com base no nome e descricao do produto.
	 */
    //private HashMap <IdentificadorCombo, ComboDoFornecedor> listaDeCombos;

    /**
     * Constroi um Fornecedor
     *
     * @param nome Representação do nome do Fornecedor
     * @param email Representação do email do Fornecedor
     * @param numero Representação do numero do Fornecedor
     */
    public Fornecedor (String nome, String email, String telefone){
		if (nome.trim().equals("") || nome == null ) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if (email.trim().equals("") || email == null ) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}

		if (telefone.trim().equals("") || telefone == null ) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.listaDeProdutos = new HashMap<>();
    }
    
    /**
     * Criado para alterar o atributo email do Fornecedor
     * @param String com o novo email do Fornecedor
     */
    public void setEmail(String email) {
    	if (email == null) {
    		throw new NullPointerException("Erro na edicao do Fornecedor: email n�o pode ser nulo");
    	}
    	if (email.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na edi��o do Fornecedor: email n�o pode ser vazio");
    	}
        this.email = email;
    }

    /**
     * Criado para alterar o atributo telefone do Fornecedor
     * @param String com o novo telefone do Fornecedor
     */
    public void setTelefone(String telefone) {
    	if (telefone == null) {
    		throw new NullPointerException("Erro na edi��o do Fornecedor: telefone n�o pode ser nulo");
    	}
    	if (telefone.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na edi��o do Fornecedor: telefone n�o pode ser vazio");
    	}
        this.telefone = telefone;
    }
    
    /**
     * Criado para retornar o nome do Fornecedor.
     * @return String com o nome do fornecedor
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Equals Baseado no nome do Fornecedor
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    /**
     * Hashcode baseado no nome do Fornecedor
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    /**
     * Representação Textual do Fornecdor
     * @return String no formato "nome - email - telefone"
     */
    @Override
    public String toString() {
        return nome + " - " + email + " - " + telefone;
    }
  
    /**
     * Criado para cadastrar um produto em um fornecedor
     * 
     * @param nome String com o nome do produto
     * @param descricao String com a descricao do produto
     * @param preco double com o preco do produto
     * @return boolean true se o cadastro obter sucesso.
     */
    public IdentificadorProduto cadastraProduto(String nome, String descricao, double preco){
    	IdentificadorProduto id = new IdentificadorProduto(nome.toLowerCase(), descricao.toLowerCase());

		if (nome.trim().equals("") || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao.trim().equals("") || descricao == null ) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
        if (listaDeProdutos.containsKey(id)){
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }

        ProdutoDoFornecedor p = new ProdutoDoFornecedor(nome, descricao, preco);
        this.listaDeProdutos.put(id, p);
        return id;
    }
    
    /**
     * Criado para retornar a Representação de um produto especifico
     *
     * @param nome - nome de produto
     * @param descricao - descricao do produto
     * @return uma String com a representa��o de um produto
     */
    public String encontraProduto (String nome, String descricao) {
    	String saida = "";
    	IdentificadorProduto id = new IdentificadorProduto(nome.toLowerCase(), descricao.toLowerCase());

		if (nome.trim().equals("") || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao.trim().equals("") || descricao == null ) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
    	if (this.listaDeProdutos.containsKey(id)) {
    		saida = this.listaDeProdutos.get(id).toString();
    	}
    	else {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }	
    	return saida;
    }

    /**
     * Criado para retornar a Representação em String de todos os produtos de um fornecedor.
     *
     * @param nome - nome o fornecedor
     * @return uma String com a Representação de uma lista com todos os produtos do fornecedor especifico.
     */
    public String listaProdutosFornecedor (String nome) {
		String saida = "";


		List<ProdutoDoFornecedor> produtoDoFornecedorList = new ArrayList<>(this.listaDeProdutos.values());
		Collections.sort(produtoDoFornecedorList);

		for (ProdutoDoFornecedor produtoDoFornecedor : produtoDoFornecedorList){

			saida += produtoDoFornecedor.toString() + " | ";

		}

		return saida.substring(0, saida.length() - 3);
    }
    
    
    /**
     * Criado para editar algum atributo do Cliente.
     *
     * @param nome String com nome do produto que ir� formar o id.
     * @param descricao String com a descricao do produto que ir� formar o id.
     * @param novoPreco double que sera o novo valor do preco do produto
     * @return String com a frase Altercao concluida
     */
    public String editaProduto(String nome, String descricao, double novoPreco) {
    	IdentificadorProduto id = new IdentificadorProduto(nome.toLowerCase(), descricao.toLowerCase());
    	
    	if (nome == null){
    		throw new NullPointerException("Erro na alteração do produto: nome n�o pode ser nulo");
    	}
    	if (nome.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na alteração do produto: nome n�o pode ser vazio");
    	}
    	if (descricao == null){
    		throw new NullPointerException("Erro na alteração do produto: descri��o n�o pode ser nulo");
    	}
    	if (descricao.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na alteração do produto: descri��o n�o pode ser vazio");
    	}
    	if (!this.listaDeProdutos.containsKey(id)) {
    		throw new IllegalArgumentException("Erro na alteração do produto: produto n�o cadastrado");
    	}
    	if (novoPreco < 0) {
    		throw new IllegalArgumentException("Erro na altera��o do produto: pre�o n�o pode ser menor que 0");
    	}
    	if (this.listaDeProdutos.containsKey(id)) {
    		this.listaDeProdutos.get(id).setPreco(novoPreco);
    	}
    	return "Alteracao concluida";
    }
    
    /**
     * Criado para remove algum produto
     *
     * @param nome String com nome do produto que sera removido.
     * @param descricao String com descricao do produto que sera removido.
     * @return String com a frase cliente removido.
     */
    public String removeProduto (String nome, String descricao) {
    	String saida = "";
    	IdentificadorProduto id = new IdentificadorProduto(nome.toLowerCase(), descricao.toLowerCase());

		if (nome == null || nome.trim().equals("")){
			throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")){
			throw new NullPointerException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (!this.listaDeProdutos.containsKey(id)){
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
        if (this.listaDeProdutos.containsKey(id)){
        	this.listaDeProdutos.remove(id);
        }
        return  saida;
    }


	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.getNome());
	}
}

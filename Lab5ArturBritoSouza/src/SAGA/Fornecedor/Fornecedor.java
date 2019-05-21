package SAGA.Fornecedor;

import SAGA.IdentificadorProdutoECombo;
import SAGA.ProdutoDoFornecedor;

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
     * Representacao dos produtos cadastrados pelo Fornecedor. Possui como chave o IdentificadorProdutoECombo que e uma classe que cria
     * uma identifcacao unica com base no nome e descricao do produto.
     */
    private HashMap <IdentificadorProdutoECombo, ProdutoDoFornecedor> listaDeProdutos;

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
		util.Validador.validaStringNull(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(nome, "Erro na edicao do Fornecedor: email nao pode ser vazio");
		util.Validador.validaStringNull(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		util.Validador.validaStringNull(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

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

		util.Validador.validaStringNull(email, "Erro na edicao do Fornecedor: email nao pode ser nulo");
		util.Validador.validaStringVazia(email, "Erro na edicao do Fornecedor: email nao pode ser vazio");
        this.email = email;
    }

    /**
     * Criado para alterar o atributo telefone do Fornecedor
     * @param String com o novo telefone do Fornecedor
     */
    public void setTelefone(String telefone) {
		util.Validador.validaStringNull(telefone, "Erro na edicao do Fornecedor: telefone nao pode ser nulo");
		util.Validador.validaStringVazia(telefone, "Erro na edicao do Fornecedor: telefone nao pode ser vazio");
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
    public IdentificadorProdutoECombo cadastraProduto(String nome, String descricao, double preco){
    	IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

		util.Validador.validaStringNull(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNull(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		util.Validador.validaStringVazia(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
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
    	IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

		util.Validador.validaStringNull(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNull(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		util.Validador.validaStringVazia(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
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
    public String listaProdutosFornecedor () {
		String saida = "";


		List<ProdutoDoFornecedor> produtoDoFornecedorList = new ArrayList<>(this.listaDeProdutos.values());
		Collections.sort(produtoDoFornecedorList);

		for (ProdutoDoFornecedor produtoDoFornecedor : produtoDoFornecedorList){

			saida += this.nome + " - " + produtoDoFornecedor.toString() + " | ";

		}

		if (saida.length() > 0) {
			return saida.substring(0, saida.length() - 3);

		}
		return this.nome + " -";
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
    	IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

		util.Validador.validaStringNull(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNull(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		util.Validador.validaStringVazia(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
    	if (!this.listaDeProdutos.containsKey(id)) {
    		throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
    	}
    	if (novoPreco < 0) {
    		throw new IllegalArgumentException("Erro na alteracao do produto: preco nao pode ser menor que 0");
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
    	IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

		util.Validador.validaStringNull(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringVazia(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNull(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		util.Validador.validaStringVazia(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		if (!this.listaDeProdutos.containsKey(id)){
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
        if (this.listaDeProdutos.containsKey(id)){
        	this.listaDeProdutos.remove(id);
        }
        return  saida;
    }

	/**
	 * Comparador baseado no nome do Fornecedor
	 */
	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.getNome());
	}
}

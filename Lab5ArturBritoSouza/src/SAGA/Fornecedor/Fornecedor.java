package SAGA.Fornecedor;

import SAGA.ProdutosEDerivados.Combo;
import SAGA.ProdutosEDerivados.IdentificadorProdutoECombo;
import SAGA.ProdutosEDerivados.Produto;
import SAGA.ProdutosEDerivados.ProdutoDoFornecedorAbstract;

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
    private HashMap <IdentificadorProdutoECombo, ProdutoDoFornecedorAbstract> listaDeProdutos;




    /**
     * Constroi um Fornecedor
     *
     * @param nome Representação do nome do Fornecedor
     * @param email Representação do email do Fornecedor
     * @param telefone Representação do numero do Fornecedor
     */
    public Fornecedor (String nome, String email, String telefone){
		util.Validador.validaStringNullEVazia(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

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

		util.Validador.validaStringNullEVazia(email, "Erro na edicao do Fornecedor: email nao pode ser nulo");
        this.email = email;
    }

    /**
     * Criado para alterar o atributo telefone do Fornecedor
     * @param String com o novo telefone do Fornecedor
     */
    public void setTelefone(String telefone) {
		util.Validador.validaStringNullEVazia(telefone, "Erro na edicao do Fornecedor: telefone nao pode ser nulo");
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
	 * Criado para retornar o mapa de lista de produtos
	 * @return o mapa de produtos do fornecedor.
	 */
	public HashMap<IdentificadorProdutoECombo, ProdutoDoFornecedorAbstract> getListaDeProdutos() {
		return listaDeProdutos;
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

		util.Validador.validaStringNullEVazia(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
        if (listaDeProdutos.containsKey(id)){
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }

        Produto p = new Produto(nome, descricao, false, preco);
        this.listaDeProdutos.put(id, p);
        return id;
    }
    
    /**
     * Criado para retornar a Representação de um produto especifico
     *
     * @param nome - nome de produto
     * @param descricao - descricao do produto
     * @return uma String com a representacao de um produto
     */
    public String encontraProduto (String nome, String descricao) {
    	String saida;
    	IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

		util.Validador.validaStringNullEVazia(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

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

		List<ProdutoDoFornecedorAbstract> produtoDoFornecedorAbstractList = new ArrayList<>(this.listaDeProdutos.values());
		Collections.sort(produtoDoFornecedorAbstractList);

		for (ProdutoDoFornecedorAbstract produtoDoFornecedorAbstract : produtoDoFornecedorAbstractList){

			saida += this.nome + " - " + produtoDoFornecedorAbstract.toString() + " | ";

		}

		if (saida.length() > 0) {
			return saida.substring(0, saida.length() - 3);

		}
		return this.nome + " -";
    }
    
    
    /**
     * Criado para editar algum atributo do Cliente.
     *
     * @param nome String com nome do produto que ira formar o id.
     * @param descricao String com a descricao do produto que ira formar o id.
     * @param novoPreco double que sera o novo valor do preco do produto
     * @return String com a frase Altercao concluida
     */
    public String editaProduto(String nome, String descricao, double novoPreco) {
    	IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

		util.Validador.validaStringNullEVazia(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
    	if (!this.listaDeProdutos.containsKey(id)) {
    		throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
    	}
    	if (novoPreco < 0) {
    		throw new IllegalArgumentException("Erro na alteracao do produto: preco nao pode ser menor que 0");
    	}
    	if (this.listaDeProdutos.containsKey(id)) {
    		this.listaDeProdutos.get(id).alteraValor(novoPreco);
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

		util.Validador.validaStringNullEVazia(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
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

    /**
     * Criado para cadastrar um combo em um fornecedor
     *
     * @param nome String com o nome do combo
     * @param descricao String com a descricao do combo
     * @param fator double com o fator do desconto do combo
     * retur id do combo cadastrado
     */
	public IdentificadorProdutoECombo cadastraCombo(String nome, String descricao, double fator, String produtos){
		util.Validador.validaStringNullEVazia(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		util.Validador.validaStringNullEVazia(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		String[] produtoCombo = produtos.split(",");

		Set<ProdutoDoFornecedorAbstract> produtosCadastro = new HashSet<>();
		for (String produto : produtoCombo) {
            String[] produtosSeparados = produto.split(" - ");
            IdentificadorProdutoECombo idProdutosSimples = new IdentificadorProdutoECombo(produtosSeparados[0].toLowerCase().trim(), produtosSeparados[1].toLowerCase().trim());


          if (!this.listaDeProdutos.containsKey(idProdutosSimples)){
                throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
          }

          if (this.listaDeProdutos.get(idProdutosSimples).isCombo()){
			  throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		  }

            ProdutoDoFornecedorAbstract p = this.listaDeProdutos.get(idProdutosSimples);
            produtosCadastro.add(p);
        }

        IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

        if (fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		if (listaDeProdutos.containsKey(id)){
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}

		Combo c = new Combo(nome, descricao, true, fator, produtosCadastro);
		this.listaDeProdutos.put(id, c);
		return id;
	}

	/**
	 * Criado para editar um combo em um fornecedor
	 *
	 * @param nome String com o nome do combo
	 * @param descricao String com a descricao do combo
	 * @param novoFator double com o novo fator do desconto do combo
	 * retur id do combo cadastrado
	 */
	public String editaCombo(String nome, String descricao, double novoFator) {
		IdentificadorProdutoECombo id = new IdentificadorProdutoECombo(nome.toLowerCase(), descricao.toLowerCase());

		util.Validador.validaStringNullEVazia(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		util.Validador.validaStringNullEVazia(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		if (!this.listaDeProdutos.containsKey(id)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		if (this.listaDeProdutos.containsKey(id)) {
			this.listaDeProdutos.get(id).alteraValor(novoFator);
		}
		return "Alteracao concluida";
	}

	/**
	 * Criado para retornar o preco do produto ou combo.
	 *
	 * @param identificador IdentificadorProdutoECombo com a id do produto ou combo que desejasse saber o preco.
	 */
	public double getPreco (IdentificadorProdutoECombo identificador){
		return listaDeProdutos.get(identificador).getPreco();
	}
}

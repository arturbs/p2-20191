package SAGA.Cliente;
import SAGA.Conta.Compra;
import SAGA.Conta.Conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Classe criada para Representar um Cliente.
 * Um Cliente e representado por um CPF, Nome, Email e
 * Localizacao. O mesmo e identificado unicamente pelo CPF.
 *
 * @author Artur Brito Souza - UFCG 
 */
public class Cliente implements Comparable<Cliente> {

	/**
     * Representacao do cpf do Cliente (Identificador Unico)
     */
	private String cpf;
	
	/**
     * Representacao do Nome do Cliente
     */
    private String nome;
    
    /**
     * Representacao do email do Cliente
     */
    private String email;
    
    /**
     * Representação da localizacao do Cliente
     */
    private String localizacao;

    /**
     * Representação da lista de contas do Cliente
     */
    private HashMap<String, Conta> contas;

    /**
     * Constroi um Cliente
     *
     * @param cpf Representacao do cpf do Cliente
     * @param nome Representacao do nome do Cliente
     * @param email Representacao do email do Cliente
     * @param localizacao Representacao da localizacao do Cliente
     */
    public Cliente (String cpf, String nome, String email, String localizacao){

        util.Validador.validaStringNullEVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo." );
        if ((cpf.length() != 11)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        util.Validador.validaStringNullEVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNullEVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        util.Validador.validaStringNullEVazia(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.localizacao = localizacao;
        this.contas = new HashMap<>();
    }

    /**
     * Equals Baseado no cpf do Cliente
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    /**
     * Hashcode baseado no cpf do Cliente
     */
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    /**
     * Criado para alterar o atributo nome do Cliente
     * @param String com o novo nome do Cliente.
     */
    public void setNome(String nome) {
        util.Validador.validaStringNullEVazia(nome,"Erro na edicao do cliente: nome nao pode ser nulo" );
        this.nome = nome;
    }

    /**
     * Criado para alterar o atributo email do Cliente
     * @param String com o novo email do Cliente.
     */
    public void setEmail(String email) {
        util.Validador.validaStringNullEVazia(email,"Erro na edicao do cliente: email nao pode ser nulo" );
        this.email = email;
    }

    /**
     * Criado para alterar o atributo localizacao do Cliente
     * @param String com a nova localizacao do Cliente.
     */
    public void setLocalizacao(String localizacao) {
        util.Validador.validaStringNullEVazia(localizacao,"Erro na edicao do cliente: localizacao nao pode ser nulo");
        this.localizacao = localizacao;
    }

    /**
     * Criado para retornar o cpf do Cliente
     * @return String com o cpf do Cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Criado para retornar o nome do Cliente
     * @return String com o nome do Cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Representacao Textual do Cliente
     * @return String no formato "nome - localizacao - email"
     */
    @Override
    public String toString() {
        return   nome + " - " +  localizacao + " - " + email;
    }

    /**
     * Comparador baseado no nome do Cliente
     */
    @Override
    public int compareTo(Cliente o) {
       return this.nome.compareTo(o.getNome());
    }

    public void cadastraCompra(String fornecedor,String data, String nomeProduto, String descricaoProduto, double preco, String nomeCliente ){
        if (!contas.containsKey(fornecedor)){
            Conta c = new Conta(fornecedor, nomeCliente);
            contas.put(fornecedor, c);
        }

        contas.get(fornecedor).cadastraCompra(fornecedor, data, nomeProduto, descricaoProduto, preco);



    }

    public String getConta(String fornecedor) {
        if (!contas.containsKey(fornecedor)){
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
        }
        return contas.get(fornecedor).toString();
    }

    public String getContas(){
        String saida = "";

        List<Conta> contasList = new ArrayList<>(this.contas.values());


        for (Conta conta: contasList) {
            saida += conta.toString() + " | ";
        }

        return saida;
    }

    public double valorDebito(String fornecedor){
        return contas.get(fornecedor).getDebito();
    }
}

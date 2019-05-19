package SAGA.Cliente;
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
     * Constroi um Cliente
     *
     * @param cpf Representacao do cpf do Cliente
     * @param nome Representacao do nome do Cliente
     * @param email Representacao do email do Cliente
     * @param localizacao Representacao da localizacao do Cliente
     */
    public Cliente (String cpf, String nome, String email, String localizacao){

        if (cpf.trim().equals("") || cpf == null || (cpf.length() != 11)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        if (nome.trim().equals("") || nome == null){
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }
        if (email.trim().equals("") || email == null){
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }
        if (localizacao.trim().equals("") || localizacao == null){
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }


        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.localizacao = localizacao;
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
    	if (nome == null) {
    		throw new NullPointerException("Erro na edicao do cliente: nome nao pode ser nulo");
    	}
    	if (nome.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na edicao do cliente: nome nao pode ser vazio");
    	}
        this.nome = nome;
    }

    /**
     * Criado para alterar o atributo email do Cliente
     * @param String com o novo email do Cliente.
     */
    public void setEmail(String email) {
    	if (email == null) {
    		throw new NullPointerException("Erro na edicao do cliente: email nao pode ser nulo");
    	}
    	if (email.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na edicao do cliente: email nao pode ser vazio");
    	}
        this.email = email;
    }

    /**
     * Criado para alterar o atributo localizacao do Cliente
     * @param String com a nova localizacao do Cliente.
     */
    public void setLocalizacao(String localizacao) {
    	if (localizacao == null) {
    		throw new NullPointerException("Erro na edicao do cliente: localizacao nao pode ser nulo");
    	}
    	if (localizacao.trim().equals("")) {
    		throw new IllegalArgumentException("Erro na edicao do cliente: localizacao nao pode ser vazio");
    	}
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
}

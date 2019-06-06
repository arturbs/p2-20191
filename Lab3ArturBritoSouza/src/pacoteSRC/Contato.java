package pacoteSRC;

import java.util.Objects;

/**
 * Representacao de um contato em uma agenda telefonica
 *
 * @author Artur Brito Souza
 */

public class Contato {
	
	/**
     * Nome do contato.
     */
    private String nome;
    
    /**
     * Sobrenome do contato.
     */
    private String sobreNome;
    
    /**
     * Numero do contato.
     */
    private String numero;

    /**
     * Constroi um contato a partir do seu nome, seu sobrenome e seu numero.
     * @param nome do contato no formato String.
     * @param sobreNome do contato no formato String.
     * @param numero do contato no formato String.
     */
    public Contato ( String nome, String  sobreNome, String numero){

        if (nome.trim().equals("") || nome.equals(null)){
            throw new IllegalArgumentException("NOME INVALIDO");
        } else if (sobreNome.trim().equals("") || sobreNome.equals(null)){
            throw new IllegalArgumentException("SOBRENOME INVALIDO");
        } else if (numero.trim().equals("") || numero.equals(null)){
            throw new IllegalArgumentException("NUMERO INVALIDO");
        }

        this.nome = nome;
        this.sobreNome = sobreNome;
        this.numero = numero;

    }
    
    /**
     * Retorna uma String com o nome do Contato.
     *
     * @return String com o nome do contato.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna uma String com o sobrenome do Contato.
     *
     * @return String com o sobrenome.
     */
     public String getSobreNome() {
        return this.sobreNome;
    }

    /**
     * Retorna uma string com todas as informacoes do contato.
     * 
     * @return String no formato nome sobrenome - numero.
     */
    @Override
    public String toString() {
        return this.nome + " " + this.sobreNome + " - " + this.numero;
    }

    /**
     * Criado para verificar se um objeto e igual a outro com base nos atributos nome e sobrenome.
     * 
     * @param o um objeto do tipo objeto.
     * 
     * @return Um booleano que retorna true se o nome e sobrenome sao iguais.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) &&
                Objects.equals(sobreNome, contato.sobreNome);
    }

    /**
     * Numero de identificacao gerado a partir dos atributos nomes e sobrenome. 
     * 
     * @return Um inteiro calculado a partir dos atributos nomes e sobrenome.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, sobreNome);
    }
}

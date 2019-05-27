package SAGA.Conta;

import java.util.Objects;

/**
 * Classe criada para Representar um identificador de conta, que sera usado como identificador unico de conta.
 * Um identificadorProduto e formado a partir do cpf do cliente e o nome do fornecedor.
 *
 * @author Artur Brito Souza - UFCG
 */
public class IdentificadorConta {

    /**
     * Representacao do cpf do cliente que sera usado para formar o id.
     */
    private String cpf;

    /**
     * Representacao do nome do fornecedor que sera usado para formar o id.
     */
    private String nomeFornecedor;

    /**
     * Constroi um identificador (para a conta).
     *
     * @param cpf Representacao do cpf do cliente que sera usado para formar o id.
     * @param descricao Representacao do nome do fornecedor que sera usado para formar o id.
     */
    public IdentificadorConta(String cpf, String nomeFornecedor) {
        this.cpf = cpf;
        this.nomeFornecedor = nomeFornecedor;
    }

    /**
     * Hashcode Baseado no cpf do cliente e no nome do fornecedor.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificadorConta that = (IdentificadorConta) o;
        return cpf.equals(that.cpf) &&
                nomeFornecedor.equals(that.nomeFornecedor);
    }

    /**
     * Equals Baseado no cpf do cliente e no nome do fornecedor.
     */
    @Override
    public int hashCode() {
        return Objects.hash(cpf, nomeFornecedor);
    }

    @Override
    public String toString() {
        return "IdentificadorConta{" +
                "cpf='" + cpf + '\'' +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                '}';
    }
}

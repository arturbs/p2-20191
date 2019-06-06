package Caixa;

import java.util.Objects;

public abstract class CaixaAbstract {

    protected String descricao;

    protected String personalizacao;

    protected String formato;

    protected String dimensoes;

    protected double preco;

    public CaixaAbstract(String descricao, String personalizacao, String formato, String dimensoes) {
        this.descricao = descricao;
        this.personalizacao = personalizacao;
        this.formato = formato;
        this.dimensoes = dimensoes;
        this.preco = 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaixaAbstract that = (CaixaAbstract) o;
        return descricao.equals(that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }

    public void setPersonalizacao(String personalizacao) {
        this.personalizacao = personalizacao;
    }

    @Override
    public String toString() {
        return "Caixa com " + personalizacao + " custa R$ " + preco + ". Formato " + formato;

    }

    public String getPersonalizacao() {
        return personalizacao;
    }

    public String getFormato() {
        return formato;
    }

    public double getPreco() {
        return preco;
    }
}

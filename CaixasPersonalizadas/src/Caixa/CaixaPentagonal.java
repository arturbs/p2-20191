package Caixa;


import Util.Validador;

public class CaixaPentagonal extends CaixaAbstract {

    private String dimensoes;
    public CaixaPentagonal(String descricao, String personalizacao, String formato, String dimensoes ) {
        super(descricao, personalizacao, formato, dimensoes);
        this.preco = calculaPreco(dimensoes);
    }

    private double calculaPreco (String dimensoes){
        double lado = Double.parseDouble(dimensoes);
        Validador.ValidaDimensao(lado, "dimensao invalida");
        double altura = (lado / 2 * Math.sqrt(5) + 2 * Math.sqrt(5))/2;
        double areaDaTampa = 5 * (lado * altura)/2;
        return this.preco = areaDaTampa * 0.1 ;
    }
}

package Caixa;

import Util.Validador;

public class CaixaCircular extends CaixaAbstract {
    public CaixaCircular(String descricao, String personalizacao, String formato, String dimensoes) {
        super(descricao, personalizacao, formato, dimensoes);
        this.preco = calculaPreco(dimensoes);
    }

    private double calculaPreco(String dimensoes){
        Double raio = Double.parseDouble(dimensoes);
        Validador.ValidaDimensao(raio, "Dimensao errada");
        Double areaDaTampa = 3.14 * Math.pow(raio,2);
        return this.preco = areaDaTampa * 0.1;
    }
}

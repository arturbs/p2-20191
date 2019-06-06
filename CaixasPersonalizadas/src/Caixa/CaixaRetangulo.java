package Caixa;

import Util.Validador;

public class CaixaRetangulo extends CaixaAbstract {
    public CaixaRetangulo(String descricao, String personalizacao, String formato, String dimensoes) {
        super(descricao, personalizacao, formato, dimensoes);
        this.preco = calculaPreco(dimensoes);
    }

    private double calculaPreco (String dimensoes) {
        String lados[] = dimensoes.split(",");

        if (lados.length > 2) {
            throw new IllegalArgumentException("Dimensoes erradas");
        }

        Double lado1 = Double.parseDouble(lados[0]);
        Double lado2 = Double.parseDouble(lados[1]);
        Validador.ValidaDimensao(lado1, "Diemnsao invalida");
        Validador.ValidaDimensao(lado2, "Diemnsao invalida");
        Double areaDaTampa = lado1 * lado2;

        return this.preco = areaDaTampa * 0.1;
    }
}

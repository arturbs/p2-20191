package Caixa

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerCaixasTest  {

    private ControllerCaixas novoControler;


    private CaixaAbstract caixa1;
    private CaixaAbstract caixa2;
    private CaixaAbstract caixa3;
    private CaixaAbstract caixa4;
    private CaixaAbstract caixa5;
    private CaixaAbstract caixa6;

    @BeforeEach
    void setUp() {
        this.novoControler = new ControllerCaixas();
        this.caixa1 = novoControler.AdicionaCaixa("oi", "arte em tecido", "Retangular", "10,7");
        this.caixa2 = novoControler.AdicionaCaixa("iai", "Colagem", "Retangular", "10,9");
        this.caixa3 = novoControler.AdicionaCaixa("opa", "Colagem", "Circular", "10");
        this.caixa4 = novoControler.AdicionaCaixa("men", "pintura a mao", "Pentagonal", "200");


    }
    @Test
    void testAdicionaCaixa() {
        this.caixa5 = novoControler.AdicionaCaixa("vida", "pintura a mao", "Retangular", "15, 10");

        assertEquals("Caixa com pintura a mao custa R\$ 15.0. Formato Retangular", novoControler.exibeCaixaEspecifica("pintura a mao","Retangular" ));

    }

    @Test
    void testModificaPersonalizacao() {
        novoControler.modificaPersonalizacao("oi", "pintura a mao");
        assertEquals("Caixa com pintura a mao custa R\$ 7.0. Formato Retangular", novoControler.exibeCaixaEspecifica("pintura a mao", "Retangular"))
    }

    @Test
    void testRemoveCaixa() {
        novoControler.removeCaixa("oi");
        assertEquals(4, novoControler.numerosDeCaixas());
    }

    @Test
    void testNumerosDeCaixas() {
        novoControler.numerosDeCaixas();
        assertEquals(4, novoControler.numerosDeCaixas());

    }

    @Test
    void testExibeCaixaEspecifica() {
    }

    @Test
    void testExibeCaixasComPersonalizacaoEspecifica() {
    }

    @Test
    void testExibeCaixasComFormatoEspecifico() {
    }

    @Test
    void testRendimentoTotal() {
    }
}

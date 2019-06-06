package Caixa

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertThrows(IllegalArgumentException.class, { -> novoControler.modificaPersonalizacao("", "") });
        assertThrows(IllegalArgumentException.class, { -> novoControler.modificaPersonalizacao("oi", "") });
        assertThrows(IllegalArgumentException.class, { -> novoControler.modificaPersonalizacao("", "pintura a mao") });


    }

    @Test
    void testRemoveCaixa() {
        novoControler.removeCaixa("oi");
        assertEquals(3, novoControler.numerosDeCaixas());
        assertThrows(IllegalArgumentException.class, { -> novoControler.removeCaixa("") });
    }

    @Test
    void testNumerosDeCaixas() {
        assertEquals(4, novoControler.numerosDeCaixas());

    }

    @Test
    void testExibeCaixaEspecifica() {
        assertEquals("Caixa com Colagem custa R\$ 9.0. Formato Retangular", novoControler.exibeCaixaEspecifica("Colagem", "Retangular"))
        assertThrows(IllegalArgumentException.class, { -> novoControler.exibeCaixaEspecifica("", "") });
        assertThrows(IllegalArgumentException.class, { -> novoControler.exibeCaixaEspecifica("", "Retangular") });
        assertThrows(IllegalArgumentException.class, { -> novoControler.exibeCaixaEspecifica("Colagem", "") });

    }

    @Test
    void testExibeCaixasComPersonalizacaoEspecifica() {
        assertEquals("Caixa com Colagem custa R\$ 9.0. Formato Retangular | Caixa com Colagem custa R\$ 31.400000000000002. Formato Circular", novoControler.exibeCaixasComPersonalizacaoEspecifica("Colagem"))
        assertThrows(IllegalArgumentException.class, { -> novoControler.exibeCaixasComPersonalizacaoEspecifica("") });

    }

    @Test
    void testExibeCaixasComFormatoEspecifico() {
        assertEquals("Caixa com Colagem custa R\$ 9.0. Formato Retangular | Caixa com arte em tecido custa R\$ 7.0. Formato Retangular", novoControler.exibeCaixasComFormatoEspecifico("Retangular"))
        assertThrows(IllegalArgumentException.class, { -> novoControler.exibeCaixasComFormatoEspecifico("") });

    }

    @Test
    void testRendimentoTotal() {
        assertEquals(5749.3733426244635, novoControler.rendimentoTotal()
        )
    }
}

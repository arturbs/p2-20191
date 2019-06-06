package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pacoteSRC.Contato;
import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {
    private Contato teste1;
    private Contato teste2;
    private Contato teste3;

    @BeforeEach
    void testeSetUp() {
        teste1 = new Contato("Artur", "Souza", "131619");
        teste2 = new Contato("Artur", "Souza", "133988");
        teste3 = new Contato("Olavo", "Brito", "555666777888999");
    }

    @Test
    void testeGetNome() {
        assertEquals("Artur", teste1.getNome());
    }

    @Test
    void testeGetSobreNome() {
        assertEquals("Souza", teste1.getSobreNome());
    }

    @Test
    void testeToString() {
        assertEquals("Artur Souza - 131619", teste1.toString());

    }

    @Test
    void testeEqualsTrue() {
        assertTrue(teste1.equals(teste2));
    }
    
    @Test
    void testeEqualsFalse() {
        assertFalse(teste1.equals(teste3) );
    }

    
}
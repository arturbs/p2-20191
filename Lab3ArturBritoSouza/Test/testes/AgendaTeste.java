package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pacoteSRC.Agenda;

class AgendaTeste {

	private Agenda teste1;

	@BeforeEach
	void testeSetUp() {
		teste1 = new Agenda();
		teste1.cadastraContatos(1, "nome", "sobreNome", "numero");
		teste1.cadastraContatos(44, "Artur", "Souza", "393357873737");
	}

	@Test
	void testeEncontraContato() {
		assertEquals("nome sobreNome - numero", teste1.encontraContato(1));
	}
	
	@Test
	void testeCadastraContatoso() {
		assertTrue(teste1.cadastraContatos(99, "nome", "sobreNome", "numero"));
	}
	
	
	@Test
	void testeListaDeContatos() {
		assertEquals("1 - nome sobreNome\n44 - Artur Souza\n", teste1.listaDeContatos());
	}

}

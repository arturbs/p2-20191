/**
 * 
 */
package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import SAGA.Cliente;

/**
 * @author Artur Brito Souza - UFCG 
 *
 */
class ClienteTest {
	
	private Cliente clienteTeste1;
	private Cliente clienteTeste2;
	private Cliente clienteTeste3;
	private Cliente clienteTeste4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	void setUpBeforeClass(){
		clienteTeste1 = new Cliente("252526", "Thor", "kingofasgard@notanymore.com", "space");
		clienteTeste2 = new Cliente("1234567", "ragnarok", "endofdays@comeon.com", "closer than u think");
		clienteTeste3 = new Cliente("1234567", "brega", "godpleasenooo@godnooo", "hell");
	}

	/**
	 * Test method for {@link SAGA.Cliente#hashCode()}.
	 */
	@Test
	final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Cliente#equals(java.lang.Object)}.
	 */
	@Test
	final void testEqualsObject() {
		assertEquals(true, this.clienteTeste2.equals(clienteTeste3));
		assertEquals(false, this.clienteTeste2.equals(clienteTeste1));
	}

	/**
	 * Test method for {@link SAGA.Cliente#setNome(java.lang.String)}.
	 */
	@Test
	final void testSetNome() {
		this.clienteTeste1.setNome("tabacudo");
		clienteTeste4 = new Cliente("252526", "tabacudo", "kingofasgard@notanymore.com", "space");
		assertEquals(true, this.clienteTeste1.equals(clienteTeste4));
	}

	/**
	 * Test method for {@link SAGA.Cliente#setEmail(java.lang.String)}.
	 */
	@Test
	final void testSetEmail() {
		this.clienteTeste1.setEmail("newemail@dealwithit.com");
		clienteTeste4 = new Cliente("252526", "Thor", "newemail@dealwithit.com", "space");
		assertEquals(true, this.clienteTeste1.equals(clienteTeste4));
	}
	

	/**
	 * Test method for {@link SAGA.Cliente#setLocalizacao(java.lang.String)}.
	 */
	@Test
	final void testSetLocalizacao() {
		this.clienteTeste1.setLocalizacao("yggdrasil");
		clienteTeste4 = new Cliente("252526", "Thor", "kingofasgard@notanymore.com", "yggdrasil");
		assertEquals(true, this.clienteTeste1.equals(clienteTeste4));
	}

	/**
	 * Test method for {@link SAGA.Cliente#getCpf()}.
	 */
	@Test
	final void testGetCpf() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Cliente#toString()}.
	 */
	@Test
	final void testToString() {
		assertEquals("Thor - space - kingofasgard@notanymore.com", this.clienteTeste1.toString());
	}

}

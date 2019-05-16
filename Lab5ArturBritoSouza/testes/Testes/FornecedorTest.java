/**
 * 
 */
package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import SAGA.Cliente;
import SAGA.Fornecedor;

/**
 * @author Artur Brito Souza - UFCG 
 *
 */
class FornecedorTest {
	
	private Fornecedor fornecedorTeste1;
	private Fornecedor fornecedorTeste2;
	private Fornecedor fornecedorTeste3;
	private Fornecedor fornecedorTeste4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	 void setUpBeforeClass() {
		fornecedorTeste1 = new Fornecedor("sapao", "drugdealer@peaceandlove.com", "64276726");
		fornecedorTeste2 = new Fornecedor("kaboom", "Allahuakba@bomm.com", "747928890");
		fornecedorTeste3 = new Fornecedor("sapao", "azulroxo@marrom.com", "2932932");
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#hashCode()}.
	 */
	@Test
	final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#Fornecedor(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testFornecedor() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#setEmail(java.lang.String)}.
	 */
	@Test
	final void testSetEmail() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#setTelefone(java.lang.String)}.
	 */
	@Test
	final void testSetTelefone() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#getNome()}.
	 */
	@Test
	final void testGetNome() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#equals(java.lang.Object)}.
	 */
	@Test
	final void testEqualsObject() {
		assertEquals(true, this.fornecedorTeste1.equals(fornecedorTeste3));
		assertEquals(false, this.fornecedorTeste1.equals(fornecedorTeste2));
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#toString()}.
	 */
	@Test
	final void testToString() {
		assertEquals("sapao - drugdealer@peaceandlove.com - 64276726", this.fornecedorTeste1.toString());
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#cadastraProduto(java.lang.String, java.lang.String, double)}.
	 */
	@Test
	final void testCadastraProduto() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#encontraProduto(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testEncontraProduto() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#listaProdutosFornecedor(java.lang.String)}.
	 */
	@Test
	final void testListaProdutosFornecedor() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#editaProduto(java.lang.String, java.lang.String, double)}.
	 */
	@Test
	final void testEditaProduto() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link SAGA.Fornecedor#removeProduto(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testRemoveProduto() {
		fail("Not yet implemented"); // TODO
	}

}

package br.com.yanaga.samples.academico.domain;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

public class NomeTest {

	@Test(expectedExceptions = NullPointerException.class)
	public void testOfNull() throws Exception {
		Nome.of(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testOfEmpty() {
		Nome.of("");
	}

	@Test
	public void testOf() {
		assertNotNull(Nome.of("TESTE"));
	}

	@Test
	public void testEquals() throws Exception {
		Nome fulano = Nome.of("FULANO");
		Nome fulano1 = Nome.of("FULANO");
		Nome beltrano = Nome.of("BELTRANO");
		assertEquals(fulano, fulano1);
		assertNotEquals(fulano, beltrano);
	}

}

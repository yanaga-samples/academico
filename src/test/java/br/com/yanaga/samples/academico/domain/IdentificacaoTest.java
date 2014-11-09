package br.com.yanaga.samples.academico.domain;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class IdentificacaoTest {

	@Test
	public void testOf() throws Exception {
		assertTrue(Identificacao.of("1234567890") instanceof Isbn);
		assertTrue(Identificacao.of("987654321X") instanceof Isbn);
		assertTrue(Identificacao.of("98.7654.321-X") instanceof Isbn);
		assertTrue(Identificacao.of("7654321X") instanceof Issn);
		assertTrue(Identificacao.of("12345678") instanceof Issn);
		assertTrue(Identificacao.of("1234567-8") instanceof Issn);
		assertTrue(Identificacao.of("1 234 567-8") instanceof Issn);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testOfInvalid() {
		Identificacao.of("123456");
	}

}

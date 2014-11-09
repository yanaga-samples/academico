package br.com.yanaga.samples.academico.domain;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IssnTest {

	@Test
	public void testFormatTo() throws Exception {
		assertEquals("ISSN 1234-5678", String.format("%s", Identificacao.of("12345678")));
		assertEquals("ISSN 1234-567X", String.format("%s", Identificacao.of("1234567X")));
	}

}

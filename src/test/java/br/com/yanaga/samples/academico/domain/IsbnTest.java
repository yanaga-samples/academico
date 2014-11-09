package br.com.yanaga.samples.academico.domain;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsbnTest {

	@Test
	public void testFormatTo() throws Exception {
		assertEquals("ISBN 12-345-6789-0",
				String.format("%s", Identificacao.of("1234567890")));
		assertEquals("ISBN 98-765-4321-X",
				String.format("%s", Identificacao.of("987654321X")));
	}

}

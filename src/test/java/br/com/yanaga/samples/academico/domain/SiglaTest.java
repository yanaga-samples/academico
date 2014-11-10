package br.com.yanaga.samples.academico.domain;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class SiglaTest {

	@Test(dataProvider = "valoresValidos")
	public void testOf(String value) throws Exception {
		assertNotNull(Sigla.of(value));
	}

	@Test(dataProvider = "valoresInvalidos",
			expectedExceptions = IllegalArgumentException.class)
	public void testOfInvalid(String value) {
		Sigla.of(value);
	}

	@DataProvider(name = "valoresValidos")
	public static Object[][] valoresValidos() {
		return new Object[][] {
				{ "ABC" },
				{ "XYZ" },
				{ "CDE" },
				{ "abc" }
		};
	}

	@DataProvider(name = "valoresInvalidos")
	public static Object[][] valoresInvalidos() {
		return new Object[][] {
				{ "AB1" },
				{ "abcd" },
				{ "123" },
				{ "1ac" }
		};
	}
}

package br.com.yanaga.samples.academico.domain;

import org.testng.annotations.Test;

public class PessoaTest {

	@Test
	public void testAno() {
		Pessoa pessoa = Pessoa.of();
		pessoa.getAno().orElse(Ano.of("2014"));
		pessoa.getAno().orElseGet(() -> Ano.of("2014"));
	}

}

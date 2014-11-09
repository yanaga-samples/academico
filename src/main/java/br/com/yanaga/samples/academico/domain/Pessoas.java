package br.com.yanaga.samples.academico.domain;

import com.mysema.query.types.expr.BooleanExpression;

public class Pessoas {

	private Pessoas() {
	}

	public static BooleanExpression comNomeContendo(String value) {
		return QPessoa.pessoa.nome.stringValue().containsIgnoreCase(value);
	}

	public static BooleanExpression comId(Long id) {
		return QPessoa.pessoa.id.eq(id);
	}

}

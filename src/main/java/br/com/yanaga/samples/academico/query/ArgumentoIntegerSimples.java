package br.com.yanaga.samples.academico.query;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.expr.NumberExpression;

import java.io.Serializable;

class ArgumentoIntegerSimples implements ArgumentoInteger, Serializable {

	private final Integer value;

	ArgumentoIntegerSimples(Integer value) {
		this.value = value;
	}

	@Override
	public void append(BooleanBuilder builder, NumberExpression<Integer> path) {
		builder.and(path.eq(value));
	}

	@Override
	public String toString() {
		return value.toString();
	}
}

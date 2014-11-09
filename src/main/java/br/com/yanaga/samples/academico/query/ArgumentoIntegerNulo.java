package br.com.yanaga.samples.academico.query;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.expr.NumberExpression;

import java.io.Serializable;

class ArgumentoIntegerNulo implements ArgumentoInteger, Serializable {
	@Override
	public void append(BooleanBuilder builder, NumberExpression<Integer> path) {
	}

	@Override
	public String toString() {
		return "";
	}
}

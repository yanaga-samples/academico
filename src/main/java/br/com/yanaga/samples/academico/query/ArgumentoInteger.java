package br.com.yanaga.samples.academico.query;

import com.google.common.base.Strings;
import com.mysema.query.types.expr.NumberExpression;

import static com.google.common.base.Preconditions.checkArgument;

public interface ArgumentoInteger extends Argumento<NumberExpression<Integer>> {

	public static ArgumentoInteger of(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return new ArgumentoIntegerNulo();
		} else {
			checkArgument(value.matches("\\d+"));
			return new ArgumentoIntegerSimples(Integer.parseInt(value));
		}
	}

}

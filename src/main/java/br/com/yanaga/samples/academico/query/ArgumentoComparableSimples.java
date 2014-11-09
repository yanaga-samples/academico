package br.com.yanaga.samples.academico.query;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.ComparablePath;

import java.io.Serializable;

class ArgumentoComparableSimples implements ArgumentoComparable, Serializable {

	private final String value;

	ArgumentoComparableSimples(String value) {
		this.value = value;
	}

	@Override
	public void append(BooleanBuilder builder, ComparablePath<?> path) {
		builder.and(path.stringValue().containsIgnoreCase(value));
	}

	@Override
	public String toString() {
		return value;
	}

}

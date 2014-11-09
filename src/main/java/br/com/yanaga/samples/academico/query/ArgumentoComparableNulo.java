package br.com.yanaga.samples.academico.query;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.ComparablePath;

import java.io.Serializable;

class ArgumentoComparableNulo implements ArgumentoComparable, Serializable {

	ArgumentoComparableNulo() {
	}

	@Override
	public void append(BooleanBuilder builder, ComparablePath<?> path) {
	}

	@Override
	public String toString() {
		return "";
	}
}

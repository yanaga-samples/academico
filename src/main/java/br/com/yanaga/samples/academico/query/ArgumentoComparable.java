package br.com.yanaga.samples.academico.query;

import com.google.common.base.Strings;
import com.mysema.query.types.path.ComparablePath;

public interface ArgumentoComparable extends Argumento<ComparablePath<?>> {

	public static ArgumentoComparable of(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return new ArgumentoComparableNulo();
		}
		else {
			return new ArgumentoComparableSimples(value);
		}
	}

}

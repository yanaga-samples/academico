package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Strings;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public abstract class Identificacao implements Serializable {

	final String value;

	Identificacao(String value) {
		this.value = value;
	}

	public static Identificacao of(String value) {
		checkNotNull(value);
		checkArgument(!Strings.isNullOrEmpty(value));
		String normalized = value.replaceAll("[^\\p{Alnum}]", "");
		if (normalized.matches("\\d{9}[\\dX]")) {
			return new Isbn(normalized);
		}
		else if (normalized.matches("\\d{7}[\\dX]")) {
			return new Issn(normalized);
		}
		throw new IllegalArgumentException("Identificação de obra inválida.");
	}

}

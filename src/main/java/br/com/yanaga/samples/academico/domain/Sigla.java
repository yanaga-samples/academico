package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Sigla implements Serializable {

	private final String value;

	private Sigla(String value) {
		this.value = value;
	}

	public static Sigla of(String value) {
		checkNotNull(value);
		checkArgument(!Strings.isNullOrEmpty(value));
		checkArgument(value.matches("\\p{Alpha}{3}"));
		return new Sigla(value.toUpperCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sigla) {
			Sigla other = (Sigla) obj;
			return Objects.equal(this.value, other.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}

	@Override
	public String toString() {
		return value;
	}

}

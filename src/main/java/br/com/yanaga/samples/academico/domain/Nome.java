package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Nome implements Serializable, Comparable<Nome> {

	private final String value;

	private Nome(String value) {
		this.value = value;
	}

	public static Nome of(String value) {
		checkNotNull(value);
		checkArgument(!Strings.isNullOrEmpty(value));
		return new Nome(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Nome) {
			Nome other = (Nome) obj;
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

	@Override
	public int compareTo(Nome o) {
		return ComparisonChain.start()
				.compare(this.value, o.value)
				.result();
	}

}

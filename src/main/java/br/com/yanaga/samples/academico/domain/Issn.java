package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Objects;

import java.util.Formatter;

class Issn extends Identificacao {

	Issn(String value) {
		super(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof br.com.yanaga.samples.academico.domain.Issn) {
			br.com.yanaga.samples.academico.domain.Issn other = (br.com.yanaga.samples.academico.domain.Issn) obj;
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
		return this.value;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		formatter.format("ISSN %s-%s",
				value.substring(0, 4),
				value.substring(4));
	}
}

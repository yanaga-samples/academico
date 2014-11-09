package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Objects;

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

}

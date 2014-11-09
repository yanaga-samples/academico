package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Objects;

import java.util.Formatter;

class Isbn extends Identificacao {

	Isbn(String value) {
		super(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof br.com.yanaga.samples.academico.domain.Isbn) {
			br.com.yanaga.samples.academico.domain.Isbn other = (br.com.yanaga.samples.academico.domain.Isbn) obj;
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
		formatter.format("ISBN %s-%s-%s-%s",
				value.substring(0, 2),
				value.substring(2, 5),
				value.substring(5, 9),
				value.substring(9));
	}

}

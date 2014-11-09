package br.com.yanaga.samples.academico.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReferenciaBibliografica implements Serializable {

	private Identificacao identificacao;

	private Ano ano;

	protected ReferenciaBibliografica() {
	}

	private ReferenciaBibliografica(Builder builder) {
		this.identificacao = builder.identificacao;
		this.ano = builder.ano;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static Builder builder(ReferenciaBibliografica referenciaBibliografica) {
		return new Builder(referenciaBibliografica);
	}

	public Identificacao getIdentificacao() {
		return identificacao;
	}

	public Ano getAno() {
		return ano;
	}

	public static class Builder implements Serializable {

		private Identificacao identificacao;

		private Ano ano;

		private Builder() {
		}

		private Builder(ReferenciaBibliografica referenciaBibliografica) {
			this.identificacao = referenciaBibliografica.identificacao;
			this.ano = referenciaBibliografica.ano;
		}

		public ReferenciaBibliografica build() {
			return new ReferenciaBibliografica(this);
		}

		public Identificacao getIdentificacao() {
			return identificacao;
		}

		public void setIdentificacao(Identificacao identificacao) {
			this.identificacao = identificacao;
		}

		public Ano getAno() {
			return ano;
		}

		public void setAno(Ano ano) {
			this.ano = ano;
		}
	}
}

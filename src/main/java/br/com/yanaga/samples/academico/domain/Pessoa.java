package br.com.yanaga.samples.academico.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Optional;

@Entity
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Nome nome;

	private Ano ano;

	protected Pessoa() {
	}

	public static Pessoa of() {
		return new Pessoa();
	}

	public Long getId() {
		return id;
	}

	public Nome getNome() {
		return nome;
	}

	public void setNome(Nome nome) {
		this.nome = nome;
	}

	public Optional<Ano> getAno() {
		return Optional.ofNullable(ano);
	}

	public void setAno(Optional<Ano> ano) {
		this.ano = ano.orElse(null);
	}
}

package br.com.yanaga.samples.academico.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Nome nome;

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

}

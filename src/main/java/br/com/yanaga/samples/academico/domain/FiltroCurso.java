package br.com.yanaga.samples.academico.domain;

import br.com.yanaga.samples.academico.query.ArgumentoComparable;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;

import java.io.Serializable;
import java.util.function.Consumer;

public class FiltroCurso implements Serializable, Consumer<JPQLQuery> {

	private ArgumentoComparable nome = ArgumentoComparable.of("");

	private FiltroCurso() {
	}

	public static FiltroCurso of() {
		return new FiltroCurso();
	}

	@Override
	public void accept(JPQLQuery jpqlQuery) {
		BooleanBuilder builder = new BooleanBuilder();
		nome.append(builder, QCurso.curso.nome);
		if (builder.hasValue()) {
			jpqlQuery.where(builder);
		}
	}

	public ArgumentoComparable getNome() {
		return nome;
	}

	public void setNome(ArgumentoComparable nome) {
		this.nome = nome;
	}
}

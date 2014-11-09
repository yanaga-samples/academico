package br.com.yanaga.samples.academico.domain;

import br.com.yanaga.samples.academico.query.ArgumentoComparable;
import br.com.yanaga.samples.academico.query.ArgumentoInteger;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;

import java.io.Serializable;
import java.util.function.Consumer;

public class FiltroDisciplina implements Serializable, Consumer<JPQLQuery> {

	private ArgumentoComparable nome = ArgumentoComparable.of("");

	private ArgumentoInteger referenciasObrigatorias = ArgumentoInteger.of("");

	private ArgumentoInteger referenciasComplementares = ArgumentoInteger.of("");

	private FiltroDisciplina() {
	}

	public static FiltroDisciplina of() {
		return new FiltroDisciplina();
	}

	@Override
	public void accept(JPQLQuery query) {
		QDisciplina qDisciplina = QDisciplina.disciplina;
		BooleanBuilder builder = new BooleanBuilder();
		nome.append(builder, qDisciplina.nome);
		referenciasObrigatorias.append(builder,
				qDisciplina.referenciasObrigatorias.size());
		referenciasComplementares.append(builder,
				qDisciplina.referenciasComplementares.size());
		if (builder.hasValue()) {
			query.where(builder);
		}
	}

	public ArgumentoComparable getNome() {
		return nome;
	}

	public void setNome(ArgumentoComparable nome) {
		this.nome = nome;
	}

	public ArgumentoInteger getReferenciasObrigatorias() {
		return referenciasObrigatorias;
	}

	public void setReferenciasObrigatorias(ArgumentoInteger referenciasObrigatorias) {
		this.referenciasObrigatorias = referenciasObrigatorias;
	}

	public ArgumentoInteger getReferenciasComplementares() {
		return referenciasComplementares;
	}

	public void setReferenciasComplementares(ArgumentoInteger referenciasComplementares) {
		this.referenciasComplementares = referenciasComplementares;
	}

}

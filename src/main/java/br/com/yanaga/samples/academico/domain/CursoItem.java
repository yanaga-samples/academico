package br.com.yanaga.samples.academico.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class CursoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "curso_fk")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "disciplina_fk")
	private Disciplina disciplina;

	protected CursoItem() {
	}

	private CursoItem(Builder builder) {
		this.curso = builder.curso;
		this.disciplina = builder.disciplina;
	}

	public static CursoItem of() {
		return new CursoItem();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Curso getCurso() {
		return curso;
	}

	public static Builder builder(Curso curso) {
		checkNotNull(curso);
		return new Builder(curso);
	}

	public String getDescricao() {
		return String.format("%s", disciplina.getNome());
	}

	public static class Builder implements Serializable {

		private final Curso curso;

		private Disciplina disciplina;

		private Builder(Curso curso) {
			this.curso = curso;
		}

		public CursoItem build() {
			return new CursoItem(this);
		}

		public Disciplina getDisciplina() {
			return disciplina;
		}

		public void setDisciplina(Disciplina disciplina) {
			this.disciplina = disciplina;
		}

	}
}

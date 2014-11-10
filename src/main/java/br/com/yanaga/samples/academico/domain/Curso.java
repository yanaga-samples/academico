package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Curso implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private Sigla sigla;

	@Column(length = Nome.TAMANHO_MAXIMO)
	private Nome nome;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<CursoItem> itens = Sets.newHashSet();

	protected Curso() {
	}

	public static Curso of() {
		return new Curso();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Curso) {
			Curso other = (Curso) obj;
			return Objects.equal(this.sigla, other.sigla);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.sigla);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("sigla", sigla)
				.add("nome", nome)
				.toString();
	}

	public void addItem(CursoItem item) {
		checkNotNull(item);
		itens.add(item);
	}

	public void removeItem(CursoItem item) {
		checkNotNull(item);
		itens.remove(item);
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

	public List<CursoItem> getItens() {
		return ImmutableList.copyOf(itens);
	}

	public List<Disciplina> getDisciplinas() {
		return itens.stream()
				.map(i -> i.getDisciplina())
				.collect(Collectors.toList());
	}

}

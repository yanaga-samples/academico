package br.com.yanaga.samples.academico.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;

@Entity
public class Disciplina implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Nome nome;

	@ElementCollection
	@CollectionTable(name = "disciplina_referencia_obrigatoria",
			joinColumns = @JoinColumn(name = "disciplina_fk"))
	private List<ReferenciaBibliografica> referenciasObrigatorias =
			Lists.newLinkedList();

	@ElementCollection
	@CollectionTable(name = "disciplina_referencia_complementar",
			joinColumns = @JoinColumn(name = "disciplina_fk"))
	private List<ReferenciaBibliografica> referenciasComplementares =
			Lists.newLinkedList();

	protected Disciplina() {
	}

	public static Disciplina of() {
		return new Disciplina();
	}

	public void addReferenciaObrigatoria(ReferenciaBibliografica referenciaBibliografica) {
		boolean naoRepetido = referenciasObrigatorias.stream()
				.noneMatch(r -> r.getIdentificacao().equals(referenciaBibliografica.getIdentificacao()));
		if (naoRepetido) {
			referenciasObrigatorias.add(referenciaBibliografica);
		}
	}

	public void addReferenciaComplementar(ReferenciaBibliografica referenciaBibliografica) {
		boolean naoRepetido = referenciasComplementares.stream()
				.noneMatch(r -> r.getIdentificacao().equals(referenciaBibliografica.getIdentificacao()));
		if (naoRepetido) {
			referenciasComplementares.add(referenciaBibliografica);
		}
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

	public List<ReferenciaBibliografica> getReferenciasObrigatorias() {
		return ImmutableList.copyOf(referenciasObrigatorias);
	}

	public List<ReferenciaBibliografica> getReferenciasComplementares() {
		return ImmutableList.copyOf(referenciasComplementares);
	}
}

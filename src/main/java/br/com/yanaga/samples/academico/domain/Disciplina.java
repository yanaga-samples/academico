package br.com.yanaga.samples.academico.domain;

import com.google.common.collect.Lists;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class Disciplina implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Nome nome;

	private List<ReferenciaBibliografica> referenciasObrigatorias =
			Lists.newLinkedList();

	private List<ReferenciaBibliografica> referenciasComplementares =
			Lists.newLinkedList();

}

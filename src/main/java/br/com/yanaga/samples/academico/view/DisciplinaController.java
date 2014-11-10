package br.com.yanaga.samples.academico.view;

import br.com.yanaga.samples.academico.domain.Disciplina;
import br.com.yanaga.samples.academico.domain.DisciplinaRepository;
import br.com.yanaga.samples.academico.domain.FiltroDisciplina;
import br.com.yanaga.samples.academico.domain.QDisciplina;
import br.com.yanaga.samples.academico.domain.ReferenciaBibliografica;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public Disciplina novo() {
		return Disciplina.of();
	}

	public List<Disciplina> complete(String query) {
		if (!Strings.isNullOrEmpty(query)) {
			QDisciplina qDisciplina = QDisciplina.disciplina;
			return disciplinaRepository.findAll(
					qDisciplina.nome.stringValue().containsIgnoreCase(query));
		}

		return Lists.newLinkedList();
	}

	public FiltroDisciplina filtro() {
		return FiltroDisciplina.of();
	}

	public ReferenciaBibliografica.Builder novaReferencia() {
		return ReferenciaBibliografica.builder();
	}

	public ReferenciaBibliografica.Builder editarReferencia(ReferenciaBibliografica referenciaBibliografica) {
		return ReferenciaBibliografica.builder(referenciaBibliografica);
	}

	public List<Disciplina> filtrar(FiltroDisciplina filtro) {
		return disciplinaRepository.findAll(filtro);
	}

	public void salvar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	}

	public void remover(Disciplina disciplina) {
		disciplinaRepository.delete(disciplina);
	}

}

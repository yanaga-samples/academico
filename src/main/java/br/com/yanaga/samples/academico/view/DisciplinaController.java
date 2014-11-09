package br.com.yanaga.samples.academico.view;

import br.com.yanaga.samples.academico.domain.Disciplina;
import br.com.yanaga.samples.academico.domain.DisciplinaRepository;
import br.com.yanaga.samples.academico.domain.ReferenciaBibliografica;
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

	public ReferenciaBibliografica.Builder novaReferencia() {
		return ReferenciaBibliografica.builder();
	}

	public ReferenciaBibliografica.Builder editarReferencia(ReferenciaBibliografica referenciaBibliografica) {
		return ReferenciaBibliografica.builder(referenciaBibliografica);
	}

	public List<Disciplina> filtrar() {
		return disciplinaRepository.findAll();
	}

	public void salvar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	}

	public void remover(Disciplina disciplina) {
		disciplinaRepository.delete(disciplina);
	}

}

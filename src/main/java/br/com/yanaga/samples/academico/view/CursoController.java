package br.com.yanaga.samples.academico.view;

import br.com.yanaga.samples.academico.domain.Curso;
import br.com.yanaga.samples.academico.domain.CursoItem;
import br.com.yanaga.samples.academico.domain.CursoRepository;
import br.com.yanaga.samples.academico.domain.FiltroCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	public Curso novo() {
		return Curso.of();
	}

	public CursoItem.Builder novoItem(Curso curso) {
		return CursoItem.builder(curso);
	}

	public FiltroCurso filtro() {
		return FiltroCurso.of();
	}

	public List<Curso> filtrar(FiltroCurso filtro) {
		return cursoRepository.findAll(filtro);
	}

	public void salvar(Curso curso) {
		cursoRepository.save(curso);
	}

	public void remover(Curso curso) {
		cursoRepository.delete(curso);
	}

}

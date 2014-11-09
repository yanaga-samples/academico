package br.com.yanaga.samples.academico.view;

import br.com.yanaga.samples.academico.domain.FiltroPessoa;
import br.com.yanaga.samples.academico.domain.Pessoa;
import br.com.yanaga.samples.academico.domain.PessoaRepository;
import br.com.yanaga.samples.academico.domain.Pessoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa novo() {
		return Pessoa.of();
	}

	public List<Pessoa> filtrar() {
		pessoaRepository.findAll(Pessoas.comNomeContendo("a").and(Pessoas.comId(123L)));
		return pessoaRepository.findAll();
	}

	public FiltroPessoa filtro() {
		return FiltroPessoa.of();
	}

	public List<Pessoa> filtrar(FiltroPessoa filtro) {
		return pessoaRepository.findAll(filtro);
	}

	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	public void remover(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}


}

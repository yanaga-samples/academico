package br.com.yanaga.samples.academico.domain;

import br.com.yanaga.samples.academico.query.ArgumentoComparable;
import br.com.yanaga.samples.academico.query.ArgumentoComparableEquals;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Created by mint on 09/11/14.
 */
public class FiltroPessoa implements Serializable, Consumer<JPQLQuery> {

    private ArgumentoComparableEquals nome = ArgumentoComparableEquals.of("");

    private FiltroPessoa() {
    }

    public static FiltroPessoa of() {
        return new FiltroPessoa();
    }

    @Override
    public void accept(JPQLQuery query) {
        QPessoa qPessoa = QPessoa.pessoa;
        BooleanBuilder builder = new BooleanBuilder();
        nome.append(builder, qPessoa.nome);
        if (builder.hasValue()) {
            query.where(builder);
        }
    }

    public ArgumentoComparableEquals getNome() {
        return nome;
    }

    public void setNome(ArgumentoComparableEquals nome) {
        this.nome = nome;
    }
}

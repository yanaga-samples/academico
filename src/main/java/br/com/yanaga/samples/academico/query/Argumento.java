package br.com.yanaga.samples.academico.query;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Expression;

public interface Argumento<T extends Expression<?>> {

	public void append(BooleanBuilder builder, T path);

}

package br.com.yanaga.samples.academico.query;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.ComparablePath;

import java.io.Serializable;

/**
 * Created by mint on 09/11/14.
 */
public class ArgumentoComparableEqualsNulo implements ArgumentoComparableEquals, Serializable {

    ArgumentoComparableEqualsNulo() {
    }

    @Override
    public void append(BooleanBuilder builder, ComparablePath<?> path) {

    }

    @Override
    public String toString() {
        return "";
    }
}

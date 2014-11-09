package br.com.yanaga.samples.academico.query;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.ComparablePath;
import java.io.Serializable;

/**
 * Created by mint on 09/11/14.
 */
public class ArgumentoComparableEqualsSimples implements ArgumentoComparableEquals, Serializable {
    private final String value;

    ArgumentoComparableEqualsSimples(String value) {
        this.value = value;
    }

    @Override
    public void append(BooleanBuilder builder, ComparablePath<?> path) {
        //builder.and(path.stringValue().containsIgnoreCase(value));
        builder.and(path.stringValue().equalsIgnoreCase(value));
    }

    @Override
    public String toString() {
        return value;
    }
}

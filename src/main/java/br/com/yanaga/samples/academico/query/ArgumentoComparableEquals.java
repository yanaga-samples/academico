package br.com.yanaga.samples.academico.query;

import com.google.common.base.Strings;
import com.mysema.query.types.path.ComparablePath;

/**
 * Created by mint on 09/11/14.
 */
public interface ArgumentoComparableEquals extends Argumento<ComparablePath<?>> {
    public static ArgumentoComparableEquals of(String value) {
        if (Strings.isNullOrEmpty(value)) {
            return new ArgumentoComparableEqualsNulo();
        }
        else {
            return new ArgumentoComparableEqualsSimples(value);
        }
    }
}

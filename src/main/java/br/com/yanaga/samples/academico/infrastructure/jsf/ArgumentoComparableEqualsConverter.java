package br.com.yanaga.samples.academico.infrastructure.jsf;

import br.com.yanaga.samples.academico.query.ArgumentoComparable;
import br.com.yanaga.samples.academico.query.ArgumentoComparableEquals;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by mint on 09/11/14.
 */
@FacesConverter(forClass = ArgumentoComparableEquals.class)
public class ArgumentoComparableEqualsConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return ArgumentoComparableEquals.of(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return null;
    }
}

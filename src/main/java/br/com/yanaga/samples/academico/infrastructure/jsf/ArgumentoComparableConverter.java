package br.com.yanaga.samples.academico.infrastructure.jsf;

import br.com.yanaga.samples.academico.query.ArgumentoComparable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ArgumentoComparable.class)
public class ArgumentoComparableConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return ArgumentoComparable.of(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return value.toString();
		}
		return null;
	}
}

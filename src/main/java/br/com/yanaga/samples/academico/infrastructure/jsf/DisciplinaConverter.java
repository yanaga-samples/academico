package br.com.yanaga.samples.academico.infrastructure.jsf;

import br.com.yanaga.samples.academico.domain.Disciplina;
import br.com.yanaga.samples.academico.domain.DisciplinaRepository;
import com.google.common.base.Strings;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (!Strings.isNullOrEmpty(value)) {
			WebApplicationContext applicationContext = FacesContextUtils.getRequiredWebApplicationContext(context);
			DisciplinaRepository disciplinaRepository = applicationContext.getBean(DisciplinaRepository.class);
			return disciplinaRepository.findOne(Long.valueOf(value)).get();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Disciplina disciplina = (Disciplina) value;
			return disciplina.getId().toString();
		}
		return null;
	}

}

package br.com.yanaga.samples.academico.infrastructure.jpa;

import br.com.yanaga.samples.academico.domain.Nome;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class NomeAttributeConverter implements AttributeConverter<Nome, String> {

	@Override
	public String convertToDatabaseColumn(Nome attribute) {
		if (attribute != null) {
			return attribute.toString();
		}
		return null;
	}

	@Override
	public Nome convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return Nome.of(dbData);
		}
		return null;
	}

}

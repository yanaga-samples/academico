package br.com.yanaga.samples.academico.infrastructure.jpa;

import br.com.yanaga.samples.academico.domain.Sigla;

import javax.persistence.AttributeConverter;

public class SiglaAttributeConverter implements AttributeConverter<Sigla, String> {
	@Override
	public String convertToDatabaseColumn(Sigla attribute) {
		if (attribute != null) {
			return attribute.toString();
		}
		return null;
	}

	@Override
	public Sigla convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return Sigla.of(dbData);
		}
		return null;
	}
}

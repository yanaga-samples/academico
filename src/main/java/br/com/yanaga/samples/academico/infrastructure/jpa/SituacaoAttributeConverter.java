package br.com.yanaga.samples.academico.infrastructure.jpa;

import br.com.yanaga.samples.academico.domain.Situacao;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SituacaoAttributeConverter implements AttributeConverter<Situacao, String> {
	@Override
	public String convertToDatabaseColumn(Situacao attribute) {
		if (attribute != null) {
			return attribute.getValue();
		}
		return null;
	}

	@Override
	public Situacao convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return Situacao.of(dbData);
		}
		return null;
	}
}

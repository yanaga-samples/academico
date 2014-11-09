package br.com.yanaga.samples.academico.infrastructure.jpa;

import br.com.yanaga.samples.academico.domain.Identificacao;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class IdentificacaoAttributeConverter implements AttributeConverter<Identificacao, String> {

	@Override
	public String convertToDatabaseColumn(Identificacao attribute) {
		if (attribute != null) {
			return attribute.toString();
		}
		return null;
	}

	@Override
	public Identificacao convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return Identificacao.of(dbData);
		}
		return null;
	}

}

package br.com.yanaga.samples.academico.infrastructure.jpa;

import br.com.yanaga.samples.academico.domain.Ano;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Date;

@Converter(autoApply = true)
public class AnoAttributeConverter implements AttributeConverter<Ano, Date> {
	@Override
	public Date convertToDatabaseColumn(Ano attribute) {
		if (attribute != null) {
			return attribute.toDate();
		}
		return null;
	}

	@Override
	public Ano convertToEntityAttribute(Date dbData) {
		if (dbData != null) {
			return Ano.of(dbData);
		}
		return null;
	}
}

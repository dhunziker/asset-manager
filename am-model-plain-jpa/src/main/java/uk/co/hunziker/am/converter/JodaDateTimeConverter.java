package uk.co.hunziker.am.converter;

import java.sql.Timestamp;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;

@Converter(autoApply = true)
public class JodaDateTimeConverter implements AttributeConverter<DateTime, java.sql.Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(DateTime attribute) {
		if (attribute == null) {
			return null;
		}
		return new Timestamp(attribute.getMillis());
	}

	@Override
	public DateTime convertToEntityAttribute(Timestamp dbData) {
		if (dbData == null) {
			return null;
		}
		return new DateTime(dbData);
	}

}

package ru.bobby.bio.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by b.istomin on 26.11.2015.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {


    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
        return Timestamp.valueOf(ldt);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp ts) {
        return ts.toLocalDateTime();
    }
}

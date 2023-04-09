package com.github.sonus21.readwrite.db.converter;

import com.github.sonus21.readwrite.models.enums.CurrencyCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.AttributeConverter;

@Slf4j
public class CurrencyCodeAttributeConverter implements AttributeConverter<CurrencyCode, String> {

    @Override
    public String convertToDatabaseColumn(CurrencyCode attribute) {
        if (attribute == null) {
            return "";
        }
        return attribute.name();
    }

    @Override
    public CurrencyCode convertToEntityAttribute(String dbData) {
        if (Strings.isEmpty(dbData)) {
            return null;
        }
        for (CurrencyCode currencyCode : CurrencyCode.values()) {
            if (currencyCode.name().equals(dbData)) {
                return currencyCode;
            }
        }

        log.error("Unexpected currency code saved in DB, currency_code={}", dbData);
        throw new RuntimeException("invalid currency code " + dbData);
    }
}

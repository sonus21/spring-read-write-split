package com.github.sonus21.readwrite.db.converter;

import com.github.sonus21.readwrite.models.enums.CurrencyCode;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;

@Slf4j
public class CurrencyCodeAttributeConverter implements AttributeConverter<CurrencyCode, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CurrencyCode attribute) {
        if (attribute == null) return 0;
        return attribute.getValue();
    }

    @Override
    public CurrencyCode convertToEntityAttribute(Integer dbData) {
        if (dbData == 0) {
            return null;
        }
        for (CurrencyCode currencyCode : CurrencyCode.values()) {
            if (currencyCode.getValue() == dbData) {
                return currencyCode;
            }
        }

        log.error("Unexpected currency code saved in DB, currency_code={}", dbData);
        throw new RuntimeException("invalid currency code " + dbData);
    }
}

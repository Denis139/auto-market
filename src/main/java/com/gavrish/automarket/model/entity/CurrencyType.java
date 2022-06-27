package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;

import java.util.Arrays;

public enum CurrencyType {

    DOLLAR ("USD"),
    EURO("EUR"),
    RUBLE("RUB");

    private final String value;

    CurrencyType(String value) {
        this.value = value;
    }

    public static Boolean fromValue(String value) {
        return Arrays.stream(CurrencyType.values())
                .map(o-> o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected CurrencyEnum value %s", value)));
    }

    public String getValue() {
        return value;
    }
}

package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;

import java.util.Arrays;

public enum TransmissionTypeEnum {
    AUTOMATIC("AUTOMATIC"),
    MECHANICAL("MECHANICAL"),
    VARIATOR("VARIATOR");

    private final String value;

    TransmissionTypeEnum(String value) {
        this.value = value;
    }

    public static TransmissionTypeEnum fromValue(String value) {
        return Arrays.stream(TransmissionTypeEnum.values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new EnumValueNotFoundException(String.format("Unexpected TransmissionTypeEnum value %s", value)));
    }

    public String getValue() {
        return value;
    }
}
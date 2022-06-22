package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;

import java.util.Arrays;

public enum EngineTypeEnum {

    GASOLINE("GASOLINE"),
    DIESEL("DIESEL"),
    HYBRID("HYBRID"),
    ELECTRICAL("ELECTRICAL");


    private final String value;

    EngineTypeEnum(String value) {
        this.value = value;
    }

    public static EngineTypeEnum fromValue(String value) {
        return Arrays.stream(EngineTypeEnum.values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new EnumValueNotFoundException(String.format("Unexpected EngineTypeEnum value %s", value)));
    }

    public String getValue() {
        return value;
    }
}

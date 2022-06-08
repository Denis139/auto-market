package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;

import java.util.Arrays;

public enum DriveTrainEnum {
    FRONT("FRONT"),
    REAR("REAR"),
    ALL("ALL");

    private final String value;

    DriveTrainEnum(String value) {
        this.value = value;
    }

    public static DriveTrainEnum fromValue(String value) {
        return Arrays.stream(DriveTrainEnum.values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new EnumValueNotFoundException(String.format("Unexpected DriveTrainEnum value %s", value)));
    }

    public String getValue() {
        return value;
    }
}

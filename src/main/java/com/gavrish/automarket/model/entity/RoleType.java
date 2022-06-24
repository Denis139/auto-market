package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;

import java.util.Arrays;

public enum RoleType {

    SELLER ("SELLER"),
    CUSTOMER ("CUSTOMER"),
    ADMIN ("ADMIN"),
    MODERATOR("MODERATOR");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    private static RoleType fromValue(String value) {
        return Arrays.stream(RoleType.values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new EnumValueNotFoundException(String.format("Unexpected RolesTypeEnum value %s", value)));
    }

    public String getValue() {
        return value;
    }
}

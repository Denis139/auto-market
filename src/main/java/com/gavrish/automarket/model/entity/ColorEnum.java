package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;
import java.util.Arrays;

public enum ColorEnum {
    METALLIC_WHITE("METALLIC_WHITE"),
    METALLIC_BLACK("METALLIC_BLACK"),
    METALLIC_GRAY("METALLIC_GRAY"),
    METALLIC_BROWN("METALLIC_BROWN"),
    METALLIC_RED("METALLIC_RED"),
    METALLIC_BLUE("METALLIC_BLUE"),
    METALLIC_GREEN("METALLIC_GREEN"),
    METALLIC_GOLD("METALLIC_GOLD"),
    METALLIC_ORANGE("METALLIC_ORANGE"),
    METALLIC_YELLOW("METALLIC_YELLOW"),
    METALLIC_PURPLE("METALLIC_PURPLE");

    private final String value;

    ColorEnum(String value) {
        this.value = value;
    }

    public static ColorEnum fromValue(String value) {
        return Arrays.stream(ColorEnum.values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new EnumValueNotFoundException(String.format("Unexpected ColorEnum value %s", value)));
    }

    public String getValue() {
        return value;
    }
}
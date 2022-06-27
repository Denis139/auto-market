package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;
import java.util.Arrays;

public enum PaymentSystem {

    VISA("VISA"),
    MASTER_CARD("MASTER_CARD"),
    MIR("MIR");

    private final String value;

    PaymentSystem(String value) {
        this.value = value;
    }

    public static PaymentSystem fromValue(String value) {
        return Arrays.stream(PaymentSystem.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected PaymentSystem value %s", value)));
    }

    public String getValue() {
        return value;
    }
}

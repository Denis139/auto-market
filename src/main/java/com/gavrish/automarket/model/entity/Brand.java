package com.gavrish.automarket.model.entity;

import com.gavrish.automarket.exception.EnumValueNotFoundException;
import java.util.Arrays;

public enum Brand {

    AUDI("AUDI"),
    BENTLEY("BENTLEY"),
    BMW("BMW"),
    CHEVROLET("CHEVROLET"),
    CITROEN("CITROEN"),
    DAEWOO("DAEWOO"),
    FERRARI("FERRARI"),
    FORD("FORD"),
    GEELY("GEELY"),
    HAVAL("HAVAL"),
    HONDA("HONDA"),
    HYUNDAI("HYUNDAI"),
    INFINITI("INFINITI"),
    KIA("KIA"),
    LAMBORGHINI("LAMBORGHINI"),
    LANDROVER("LAND ROVER"),
    LEXUS("LEXUS"),
    LIFAN("LIFAN"),
    MASERATI("MASERATI"),
    MINI("MINI"),
    MAZDA("MAZDA"),
    MERCEDES_BENZ("MERCEDES-BENZ"),
    MITSUBISHI("MITSUBISHI"),
    NISSAN("NISSAN"),
    PEUJEOT("PEUJEOT"),
    PORSCHE("PORSCHE"),
    RENAULT("RENAULT"),
    SKODA("SKODA"),
    SUBARU("SUBARU"),
    SUZUKI("SUZUKI"),
    TOYOTA("TOYOTA"),
    VOLKSWAGEN("VOLKSWAGEN"),
    VOLVO("VOLVO");

    private final String value;

    Brand(String value) {
        this.value = value;
    }

    public static Brand fromValue(String value) {
        return Arrays.stream(Brand.values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new EnumValueNotFoundException(String.format("Unexpected Brand value %s", value)));
    }

    public String getValue() {
        return value;
    }
}

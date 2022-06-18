package com.gavrish.automarket.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.type.TextType;
import java.util.UUID;

@Data
@Accessors
public class FactoryView {

    private UUID id;

    private String factoryName;

    private TextType country;

    private TextType region;

    private TextType city;

    private Integer employees;

}

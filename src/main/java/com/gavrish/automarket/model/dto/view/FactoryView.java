package com.gavrish.automarket.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.type.TextType;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class FactoryView {

    private UUID id;

    private String factoryName;

    private String country;

    private String region;

    private String city;

    private Integer employees;

}

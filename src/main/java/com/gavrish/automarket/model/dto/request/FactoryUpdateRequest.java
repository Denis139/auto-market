package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.type.TextType;

import java.util.UUID;

@Data
@Accessors
public class FactoryUpdateRequest {

    private UUID id;

    private String factoryName;

    private String country;

    private Integer employees;       // notNull

}

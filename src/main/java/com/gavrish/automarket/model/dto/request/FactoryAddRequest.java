package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.type.TextType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors
public class FactoryAddRequest {

    @NotBlank(message = "Field [factoryName] must be present")
    private String factoryName;

    @NotBlank(message = "Field [country] must be present")
    private String country;

    @NotBlank(message = "Field[region] must be present")
    private String region;

    @NotBlank(message = "Field[city] must be present")
    private String city;

    @NotNull(message = "Field [employees] mustn't be null")
    private Integer employees;
}

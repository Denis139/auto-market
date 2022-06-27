package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.EngineTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class EngineAddRequest {

    @NotBlank(message = "Field [name] must be present")
    private String name;

    @NotNull(message = "Field [engineTypeEnum] mustn't be null")
    private EngineTypeEnum engineTypeEnum;

    @NotNull(message = "Field [volume] mustn't be null")
    private Double volume;

    @NotNull(message = "Field [power] mustn't be null")
    private Integer power;

    @NotNull(message = "Field [torque] mustn't be null")
    private Integer torque;

    @NotNull(message = "Field [fuel] mustn't be null")
    private Integer fuel;

    private String warranty;

}

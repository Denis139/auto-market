package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class WheelAddRequest {

    @NotBlank(message = "Field [name] must be present")
    private String name;

    private Double diameter;

    @NotNull(message = "Field [width] mustn't be null")
    private Double width;

    @NotNull(message = "Field [numberHoles] mustn't be null")
    private Integer numberHoles;

    @NotBlank(message = "Field [bolt_pattern] must be present")
    private String boltPattern;

    @NotNull(message = "Field [weight] mustn't be null")
    private Double weight;

    @NotNull(message = "Field [modeId] mustn't be null")
    private UUID modelId;

}

package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.EngineTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class EngineAddRequest {

    @NotNull(message = "Field [name] must be present")     /////// должно быть нотБланк
    private String name;

    @NotNull(message = "Field [engineTypeEnum] must be present")
    private EngineTypeEnum engineTypeEnum;

    @NotNull(message = "Field [volume] must be present")
    private Double volume;

    @NotNull(message = "Field [power] must be present")
    private Integer power;

    @NotNull(message = "Field[torque] must be present")
    private Integer torque;

    @NotNull(message = "Field [fuel] must be present")
    private Integer fuel;

    private String warranty;

}

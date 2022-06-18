package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.TransmissionTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;

@Data
@Accessors
public class TransmissionAddRequest {

    @NotNull(message = "Field [name] must be present")
    private String name;

    @NotNull(message = "Field [transmissionTypeEnum] must be present")
    private TransmissionTypeEnum transmissionTypeEnum;

    @NotNull(message = "Field [numberGears] mustn't be null")
    private Integer numberGears;

}

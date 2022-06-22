package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.TransmissionTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class TransmissionAddRequest {

    @NotBlank(message = "Field [name] must be present")
    private String name;

    @NotNull(message = "Field [transmissionType] mustn't be null")
    private TransmissionTypeEnum transmissionType;

    @NotNull(message = "Field [numberGears] mustn't be null")
    private Integer numberGears;

}

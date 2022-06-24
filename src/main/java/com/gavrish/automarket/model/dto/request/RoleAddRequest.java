package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.RoleType;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class RoleAddRequest {

    @NotNull(message = "Field [roleType] must be present")
    private RoleType roleType;

    @NotBlank(message = "Field [description] must be present")
    private String description;

}

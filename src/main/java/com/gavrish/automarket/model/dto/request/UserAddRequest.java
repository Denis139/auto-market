package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserAddRequest {

    @NotBlank(message = "Field [country] must be present")
    private String firstname;

    @NotBlank(message = "Field [lastname] must be present")
    private String lastname;

    @NotNull(message = "Field [telephoneNumber] mustn't be null")
    private Integer telephoneNumber;

    @NotBlank(message = "Field [email] must be present")
    private String email;

    List<UUID> roleIds = new LinkedList<>();

}

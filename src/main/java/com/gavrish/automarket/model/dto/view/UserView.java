package com.gavrish.automarket.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserView {

    private UUID id;

    private String firstname;

    private String lastname;

    private Integer telephoneNumber;

    private String email;

}

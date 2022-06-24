package com.gavrish.automarket.model.dto.view;

import com.gavrish.automarket.model.entity.RoleType;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class RoleView {

    private UUID id;

    private RoleType roleType;

    private String description;

}

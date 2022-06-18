package com.gavrish.automarket.model.dto.view;

import com.gavrish.automarket.model.entity.EngineTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class EngineView {

    private UUID id;

    private EngineTypeEnum engineType;

    private Double volume;

    private Integer power;

    private Integer torque;

    private Integer fuel;

    private String warranty;
}

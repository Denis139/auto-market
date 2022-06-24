package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.*;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ModelAddRequest {

    @NotBlank(message = "Field[name] must be present")
    private String name;

    @NotNull(message = "Field[driveTrain] must be present")
    private DriveTrainEnum driveTrain;

    @NotNull(message = "Field[fuelConsumption] must be present")
    private Double fuelConsumption;

    private ColorEnum color;

    @NotNull(message = "Field[engine] must be present")
    private UUID engineId;

    @NotNull(message = "Field[transmission] must be present")
    private UUID transmissionId;

    @NotNull(message = "Field[wheelId] must be present")
    private UUID wheelId;

    List<UUID> factoryIds = new LinkedList<>();
}

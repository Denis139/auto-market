package com.gavrish.automarket.model.dto.view;

import com.gavrish.automarket.model.entity.ColorEnum;
import com.gavrish.automarket.model.entity.DriveTrainEnum;
import com.gavrish.automarket.model.entity.Engine;
import com.gavrish.automarket.model.entity.Transmission;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class ModelView {

    private UUID id;

    private String name;

    private DriveTrainEnum driveTrain;

    private Double fuelConsumption;

    private ColorEnum color;

    private Engine engine;

    private Transmission transmission;

}

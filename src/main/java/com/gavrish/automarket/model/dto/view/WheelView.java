package com.gavrish.automarket.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class WheelView {

    private UUID id;

    private Double diameter;

    private Double width;

    private Integer numberHoles;

    private String boltPattern;

    private Double weight;
}

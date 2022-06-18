package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors
public class WheelUpdateRequest {

    private UUID id;

    private Double diameter;
}

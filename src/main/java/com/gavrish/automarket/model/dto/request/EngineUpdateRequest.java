package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class EngineUpdateRequest {

    private String name;

    private String warranty;
}

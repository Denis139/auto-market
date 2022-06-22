package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors
public class EngineUpdateRequest {

    private UUID id;

    private String name;

    private String warranty;
}

package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.ColorEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.UUID;

@Data
@Accessors
public class ModelUpdateRequest {

    private UUID id;

    private ColorEnum color;

}

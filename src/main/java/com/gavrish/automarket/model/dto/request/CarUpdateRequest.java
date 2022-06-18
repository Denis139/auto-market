package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CarUpdateRequest {

    private UUID id;

    private Long mileage;

    private BigDecimal price;
}

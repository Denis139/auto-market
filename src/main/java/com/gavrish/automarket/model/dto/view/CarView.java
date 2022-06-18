package com.gavrish.automarket.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CarView {

    private UUID id;

    private String brand;

    private Long mileage;

    private BigDecimal price;

    private LocalDateTime yearOfIssue;

    private UUID modelId;
}
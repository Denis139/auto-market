package com.gavrish.automarket.model.dto.view;

import com.gavrish.automarket.model.entity.Brand;
import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CarView {

    private UUID id;

    private Brand brand;

    private Long mileage;

    private BigDecimal price;

    private Integer yearOfIssue;

    private UUID modelId;
}
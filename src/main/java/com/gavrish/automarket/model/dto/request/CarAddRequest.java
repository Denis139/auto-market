package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CarAddRequest{

    @NotBlank(message = "Field [brand] must be present")
    private String brand;

    @NotNull(message = "Field [yearOfIssue] mustn't be null")
    private LocalDateTime yearOfIssue;

    private Long mileage;

    private BigDecimal price;

    @NotNull(message = "Field [modelId] mustn't be null")
    private UUID modelId;
}

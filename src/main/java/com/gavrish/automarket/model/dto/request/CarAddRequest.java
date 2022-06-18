package com.gavrish.automarket.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CarAddRequest{

    @NotBlank(message = "Field [brand] must be present")    // поле брэнд обязательно
    private String brand;

    @NotBlank(message = "Field [yearOfIssue] mustn't be null")
    private LocalDateTime yearOfIssue;

    private Long mileage;

    private BigDecimal price;

    @NotBlank(message = "Field [modelId] must be present")
    private UUID modelId;
}

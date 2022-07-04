package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.Brand;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CarAddRequest{

    @NotNull(message = "Field [brand] mustn't be null")
    private Brand brand;

    @NotNull(message = "Field [yearOfIssue] mustn't be null")
    private Integer yearOfIssue;

    private Long mileage;

    private BigDecimal price;

    @NotNull(message = "Field [modelId] mustn't be null")
    private UUID modelId;
}

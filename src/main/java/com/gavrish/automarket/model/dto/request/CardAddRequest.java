package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.PaymentSystem;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CardAddRequest {

    @NotBlank(message = "Field [number] must be present")
    private String number;

    @NotBlank(message = "Field [name] must be present")
    private String name;

    @NotNull(message = "Field [date] mustn't be null")
    private LocalDateTime date;

    @NotBlank(message = "Field [cvv] must be present")
    private String cvv;

    @NotNull(message = "Field [paymentSystem] mustn't be null")
    private PaymentSystem paymentSystem;
}

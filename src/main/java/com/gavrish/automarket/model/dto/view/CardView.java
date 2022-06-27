package com.gavrish.automarket.model.dto.view;

import com.gavrish.automarket.model.entity.PaymentSystem;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CardView {

    private UUID id;

    private String number;

    private String name;

    private LocalDateTime date;

    private String cvv;

    private PaymentSystem paymentSystem;
}

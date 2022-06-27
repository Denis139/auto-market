package com.gavrish.automarket.model.dto.request;

import com.gavrish.automarket.model.entity.CurrencyType;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class TransactionAddRequest {

    private String idTransaction;

    @NotNull(message = "Field [date] mustn't be null")
    private LocalDateTime date;

    @NotNull(message = "Field [amount] mustn't be null")
    private BigDecimal amount;

    @NotNull(message = "Field [currency] mustn't be null")
    private CurrencyType currency;

    @NotNull(message = "Field [card_id] mustn't be null")
    private UUID cardId;
}

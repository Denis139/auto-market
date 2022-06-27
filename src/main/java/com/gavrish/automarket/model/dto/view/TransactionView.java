package com.gavrish.automarket.model.dto.view;

import com.gavrish.automarket.model.entity.CurrencyType;
import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class TransactionView {

    private UUID id;

    private String idTransaction;

    private LocalDateTime date;

    private BigDecimal amount;

    private CurrencyType currency;

}

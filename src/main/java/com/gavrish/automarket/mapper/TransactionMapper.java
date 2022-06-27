package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.TransactionAddRequest;
import com.gavrish.automarket.model.dto.view.TransactionView;
import com.gavrish.automarket.model.entity.Transaction;

public interface TransactionMapper {

    Transaction from(TransactionAddRequest source);

    TransactionView from(Transaction source);
}

package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.TransactionMapper;
import com.gavrish.automarket.model.dto.request.TransactionAddRequest;
import com.gavrish.automarket.model.dto.view.TransactionView;
import com.gavrish.automarket.model.entity.Transaction;
import org.springframework.stereotype.Service;

@Service()
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction from(TransactionAddRequest source) {
        return new Transaction()
                .setBankIdTransaction(source.getIdTransaction())
                .setDate(source.getDate())
                .setAmount(source.getAmount())
                .setCurrency(source.getCurrency());
    }

    @Override
    public TransactionView from(Transaction source) {
        return new TransactionView()
                .setId(source.getId())
                .setIdTransaction(source.getBankIdTransaction())
                .setDate(source.getDate())
                .setAmount(source.getAmount())
                .setCurrency(source.getCurrency());
    }
}

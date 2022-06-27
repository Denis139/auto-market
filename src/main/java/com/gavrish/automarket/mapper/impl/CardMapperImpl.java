package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.CardMapper;
import com.gavrish.automarket.model.dto.request.CardAddRequest;
import com.gavrish.automarket.model.dto.view.CardView;
import com.gavrish.automarket.model.entity.Card;
import org.springframework.stereotype.Service;

@Service
public class CardMapperImpl implements CardMapper {

    @Override
    public Card from(CardAddRequest source) {
        return new Card()
                .setNumber(source.getNumber())
                .setName(source.getName())
                .setDate(source.getDate())
                .setCvv(source.getCvv())
                .setPaymentSystem(source.getPaymentSystem());
    }

    @Override
    public CardView from(Card source) {
        return new CardView()
                .setId(source.getId())
                .setNumber(source.getNumber())
                .setName(source.getName())
                .setDate(source.getDate())
                .setCvv(source.getCvv())
                .setPaymentSystem(source.getPaymentSystem());
    }
}

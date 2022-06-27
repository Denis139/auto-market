package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.CardAddRequest;
import com.gavrish.automarket.model.dto.view.CardView;
import com.gavrish.automarket.model.entity.Card;

public interface CardMapper {

    Card from(CardAddRequest source);

    CardView from(Card source);
}

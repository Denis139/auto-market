package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.CardAddRequest;
import com.gavrish.automarket.model.dto.view.CardView;
import com.gavrish.automarket.model.entity.Card;
import java.util.List;
import java.util.UUID;

public interface CardDomainService {

    UUID add(CardAddRequest request);

    CardView get(UUID id);

    List<CardView> getAll();

    Boolean delete(UUID id);
}

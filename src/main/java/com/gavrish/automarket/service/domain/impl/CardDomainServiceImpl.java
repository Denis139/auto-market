package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.CardMapper;
import com.gavrish.automarket.model.dto.request.CardAddRequest;
import com.gavrish.automarket.model.dto.view.CardView;
import com.gavrish.automarket.model.entity.Card;
import com.gavrish.automarket.repository.CardRepository;
import com.gavrish.automarket.service.domain.CardDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class CardDomainServiceImpl implements CardDomainService {

    private CardRepository cardRepository;
    private CardMapper cardMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(CardAddRequest request) {
        var card =  cardMapper.from(request);
        card = cardRepository.saveAndFlush(card);
        return card.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public CardView get(UUID id) {
        return cardMapper.from(findByid(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CardView> getAll() {
        return cardRepository.findAll()
                .stream()
                .map(o->cardMapper.from(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var card = findByid(id);
        cardRepository.delete(card);
        cardRepository.flush();

        return !cardRepository.existsById(id);
    }

    private Card findByid(UUID id) {
        return cardRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Card with id [%s] not found", id)));
    }
}

package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.CardAddRequest;
import com.gavrish.automarket.model.dto.view.CardView;
import com.gavrish.automarket.service.domain.CardDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class CardController {

    private CardDomainService cardDomainService;

    @PostMapping(value = ADD_CARD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid CardAddRequest request) {
        return cardDomainService.add(request);
    }
    @GetMapping(value = GET_CARD)
    public CardView get(@PathVariable UUID id) {
        return cardDomainService.get(id);
    }
    @GetMapping(value = GET_ALL_CARD)
    public List<CardView> getAll() {
        return cardDomainService.getAll();
    }
    @DeleteMapping(value = DELETE_CARD)
    public Boolean delete(@PathVariable UUID id) {
        return cardDomainService.delete(id);
    }
}

package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.dto.request.FactoryUpdateRequest;
import com.gavrish.automarket.model.dto.view.FactoryView;
import com.gavrish.automarket.service.domain.FactoryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class FactoryController {

    private final FactoryDomainService factoryDomainService;

    @PostMapping(value = ADD_FACTORY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid FactoryAddRequest request) {
        return factoryDomainService.add(request);
    }

    @GetMapping(value = GET_FACTORY)
    public FactoryView get(@PathVariable UUID id) {
        return factoryDomainService.get(id);
    }

    @GetMapping(value = GET_ALL_FACTORY)
    public List<FactoryView> getAll() {
        return factoryDomainService.getAll();
    }

    @PatchMapping(value = UPDATE_FACTORY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public FactoryView update(@PathVariable UUID id, @RequestBody @Valid FactoryUpdateRequest request) {
        return factoryDomainService.update(id, request);
    }

    @DeleteMapping(value = DELETE_FACTORY)
    public Boolean delete(@PathVariable UUID id) {
        return factoryDomainService.delete(id);
    }
}
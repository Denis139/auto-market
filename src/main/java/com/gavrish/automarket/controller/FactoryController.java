package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.service.domain.FactoryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.ADD_FACTORY;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class FactoryController {

    private final FactoryDomainService factoryDomainService;

    @PostMapping(value = ADD_FACTORY)
    public UUID add(@RequestBody @Valid FactoryAddRequest request) {
        return factoryDomainService.add(request);
    }
}

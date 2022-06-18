package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.service.domain.ModelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.ADD_MODEL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class ModelController {

    private final ModelDomainService modelDomainService;

    @PostMapping(value = ADD_MODEL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid ModelAddRequest request) {
        return modelDomainService.add(request);
    }
}

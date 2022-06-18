package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.service.domain.CarDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.ADD_CAR;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class CarController {

    private final CarDomainService carDomainService;

    @PostMapping(value = ADD_CAR)
    public UUID add (@RequestBody @Valid CarAddRequest request) {
        return carDomainService.add(request);
    }
}


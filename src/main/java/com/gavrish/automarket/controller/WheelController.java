package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.service.domain.WheelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.ADD_WHEEL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class WheelController {

    private final WheelDomainService wheelDomainService;

    @PostMapping(value = ADD_WHEEL)
    public UUID add(@RequestBody @Valid WheelAddRequest request) {
        return wheelDomainService.add(request);
    }
}

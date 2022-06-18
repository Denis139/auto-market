package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.service.domain.TransmissionDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.ADD_TRANSMISSION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class TransmissionController {

    private final TransmissionDomainService transmissionDomainService;

    @PostMapping(value = ADD_TRANSMISSION)
    public UUID add(@RequestBody @Valid TransmissionAddRequest request) {
        return transmissionDomainService.add(request);
    }
}

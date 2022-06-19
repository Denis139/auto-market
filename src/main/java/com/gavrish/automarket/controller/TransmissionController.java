package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.dto.request.TransmissionUpdateRequest;
import com.gavrish.automarket.model.dto.view.TransmissionView;
import com.gavrish.automarket.service.domain.TransmissionDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class TransmissionController {

    private final TransmissionDomainService transmissionDomainService;

    @PostMapping(value = ADD_TRANSMISSION, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid TransmissionAddRequest request) {
        return transmissionDomainService.add(request);
    }

    @GetMapping(value = GET_TRANSMISSION)
    public TransmissionView get(@PathVariable UUID id) {
        return transmissionDomainService.get(id);
    }

    @GetMapping(value = GET_ALL_TRANSMISSION)
    List<TransmissionView> getAll() {
        return transmissionDomainService.getAll();
    }


//@PatchMapping(value = UPDATE_TRANSMISSION, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public TransmissionView update(@PathVariable UUID id, @RequestBody @Valid TransmissionUpdateRequest request) {
//        return transmissionDomainService.update(id, request);

    @DeleteMapping(value = DELETE_TRANSMISSION)
    public Boolean delete(@PathVariable UUID id) {
        return transmissionDomainService.delete(id);
    }
}

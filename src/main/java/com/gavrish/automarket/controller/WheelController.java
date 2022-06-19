package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.dto.request.WheelUpdateRequest;
import com.gavrish.automarket.model.dto.view.WheelView;
import com.gavrish.automarket.service.domain.WheelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class WheelController {

    private final WheelDomainService wheelDomainService;

    @PostMapping(value = ADD_WHEEL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid WheelAddRequest request) {
        return wheelDomainService.add(request);
    }

    @GetMapping(value = GET_WHEEL)
    public WheelView get(@PathVariable UUID id) {
        return wheelDomainService.get(id);
    }

    @GetMapping(value = GET_ALL_WHEEL)
    public List<WheelView> getAll() {
        return wheelDomainService.getAll();
    }

    @PatchMapping(value = UPDATE_WHEEL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public WheelView update(@PathVariable UUID id, @RequestBody @Valid WheelUpdateRequest request) {
        return wheelDomainService.update(id, request);
    }

    @DeleteMapping(value = DELETE_WHEEL)
   public Boolean delete(@PathVariable UUID id) {
        return wheelDomainService.delete(id);
    }
}

package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.EngineAddRequest;
import com.gavrish.automarket.model.dto.request.EngineUpdateRequest;
import com.gavrish.automarket.model.dto.view.EngineView;
import com.gavrish.automarket.service.domain.EngineDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class EngineController {

    private final EngineDomainService engineDomainService;

    @PostMapping(value = ADD_ENGINE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid EngineAddRequest request) {
        return engineDomainService.add(request);
    }

    @GetMapping(value = GET_ENGINE)
    public EngineView get(@PathVariable UUID id) {
        return engineDomainService.get(id);
    }

    @GetMapping(value = GET_ALL_ENGINE)
    public List<EngineView> getAll() {
        return engineDomainService.getAll();
    }

    @PatchMapping(value = UPDATE_ENGINE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public EngineView update(@PathVariable UUID id, @RequestBody @Valid EngineUpdateRequest request) {
        return engineDomainService.update(id, request);
    }

    @DeleteMapping(value = DELETE_ENGINE)
    public Boolean delete(@PathVariable UUID id) {
        return engineDomainService.delete(id);
    }
}
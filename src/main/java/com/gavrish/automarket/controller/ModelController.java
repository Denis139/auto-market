package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.dto.request.ModelUpdateRequest;
import com.gavrish.automarket.model.dto.view.ModelView;
import com.gavrish.automarket.service.domain.ModelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class ModelController {

    private final ModelDomainService modelDomainService;

    @PostMapping(value = ADD_MODEL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid ModelAddRequest request) {
        return modelDomainService.add(request);
    }

    @GetMapping(value = GET_MODEL)
    public ModelView get(@PathVariable UUID id) {
        return modelDomainService.get(id);
    }
    @GetMapping(value = GET_ALL_MODEL)
    public List<ModelView> getAll() {
        return modelDomainService.getAll();
    }
    @PatchMapping(value = UPDATE_MODEL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ModelView update(@PathVariable UUID id, @RequestBody @Valid ModelUpdateRequest request) {
        return modelDomainService.update(id, request);
    }

    @DeleteMapping(value = DELETE_MODEL)
    public Boolean delete(@PathVariable UUID id) {
        return modelDomainService.delete(id);
    }
}

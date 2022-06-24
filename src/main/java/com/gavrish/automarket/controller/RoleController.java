package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.RoleAddRequest;
import com.gavrish.automarket.model.dto.view.RoleView;
import com.gavrish.automarket.service.domain.RoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private RoleDomainService roleDomainService;

    @PostMapping(value = ADD_ROLE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid RoleAddRequest request) {
        return roleDomainService.add(request);
    }

    @GetMapping(value = GET_ROLE)
    public RoleView get(@PathVariable UUID id) {
        return roleDomainService.get(id);
    }

    @GetMapping(value = GET_ALL_ROLE)
    public List<RoleView> getAll() {
        return roleDomainService.getAll();
    }

    @DeleteMapping(value = DELETE_ROLE)
    public Boolean delete(@PathVariable UUID id) {
        return roleDomainService.delete(id);
    }
}

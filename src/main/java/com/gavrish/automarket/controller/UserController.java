package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.UserAddRequest;
import com.gavrish.automarket.model.dto.view.UserView;
import com.gavrish.automarket.service.domain.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserDomainService userDomainService;

    @PostMapping(value = ADD_USER, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid UserAddRequest request) {
       return userDomainService.add(request);
   }

   @GetMapping(value = GET_USER)
    public UserView get(@PathVariable UUID id) {
        return userDomainService.get(id);
    }

    @GetMapping(value = GET_ALL_USER)
    public List<UserView> getAll() {
        return userDomainService.getAll();
    }

    @DeleteMapping(value = DELETE_USER)
    public Boolean delete(@PathVariable UUID id) {
        return userDomainService.delete(id);
    }
}

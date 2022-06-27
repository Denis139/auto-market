package com.gavrish.automarket.controller;

import com.gavrish.automarket.model.dto.request.TransactionAddRequest;
import com.gavrish.automarket.model.dto.view.TransactionView;
import com.gavrish.automarket.service.domain.TransactionDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static com.gavrish.automarket.util.Constant.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionDomainService transactionDomainService;

    @PostMapping(value = ADD_TRANSACTION, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid TransactionAddRequest request) {
        return transactionDomainService.add(request);
    }

    @GetMapping(value = GET_TRANSACTION)
    public TransactionView get(@PathVariable UUID id) {
        return transactionDomainService.get(id);
    }

    @GetMapping(value = GET_ALL_TRANSACTION)
    public List<TransactionView> getAll() {
        return transactionDomainService.getAll();
    }

    @DeleteMapping(value = DELETE_TRANSACTION)
    public Boolean delete(UUID id) {
        return transactionDomainService.delete(id);
    }
}

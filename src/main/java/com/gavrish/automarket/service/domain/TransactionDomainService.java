package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.TransactionAddRequest;
import com.gavrish.automarket.model.dto.view.TransactionView;
import java.util.List;
import java.util.UUID;

public interface TransactionDomainService {

    UUID add(TransactionAddRequest request);

    TransactionView get(UUID id);

    List<TransactionView> getAll();

    Boolean delete(UUID id);
}

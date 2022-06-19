package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.dto.request.FactoryUpdateRequest;
import com.gavrish.automarket.model.dto.view.FactoryView;

import java.util.List;
import java.util.UUID;

public interface FactoryDomainService {

    UUID add(FactoryAddRequest request);

    FactoryView get(UUID id);

    List<FactoryView> getAll();

    FactoryView update(UUID id, FactoryUpdateRequest request);

    Boolean delete(UUID id);
}

package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.EngineAddRequest;
import com.gavrish.automarket.model.dto.request.EngineUpdateRequest;
import com.gavrish.automarket.model.dto.view.EngineView;
import java.util.List;
import java.util.UUID;

public interface EngineDomainService {

    UUID add(EngineAddRequest request);

    EngineView get(UUID id);

    List<EngineView> getAll();

    EngineView update(UUID engineId, EngineUpdateRequest request);

    Boolean delete(UUID id);
}

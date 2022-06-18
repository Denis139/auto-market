package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.dto.request.ModelUpdateRequest;
import com.gavrish.automarket.model.dto.view.ModelView;
import java.util.List;
import java.util.UUID;

public interface ModelDomainService {

    UUID add(ModelAddRequest request);

    ModelView get(UUID id);

    List<ModelView> getAll();

    ModelView update (ModelUpdateRequest request);

    void delete(UUID id);
}

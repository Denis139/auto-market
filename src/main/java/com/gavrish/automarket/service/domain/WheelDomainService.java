package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.dto.request.WheelUpdateRequest;
import com.gavrish.automarket.model.dto.view.WheelView;
import java.util.List;
import java.util.UUID;

public interface WheelDomainService {

    UUID add(WheelAddRequest request);

    WheelView get(UUID id);

    List<WheelView> getAll();

    WheelView update(UUID id, WheelUpdateRequest request);

    Boolean delete(UUID id);
}

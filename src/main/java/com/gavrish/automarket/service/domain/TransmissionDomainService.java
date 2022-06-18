package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.dto.request.TransmissionUpdateRequest;
import com.gavrish.automarket.model.dto.view.TransmissionView;
import java.util.List;
import java.util.UUID;

public interface TransmissionDomainService {

    UUID add(TransmissionAddRequest request);

    TransmissionView get(UUID id);

    List<TransmissionView> getAll();

    TransmissionView update(TransmissionUpdateRequest request);

    void delete(UUID id);
}

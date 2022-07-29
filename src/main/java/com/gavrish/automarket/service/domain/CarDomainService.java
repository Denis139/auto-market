package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.dto.request.CarUpdateRequest;
import com.gavrish.automarket.model.dto.view.CarView;
import java.util.List;
import java.util.UUID;

public interface CarDomainService {

    UUID add(CarAddRequest request);

    CarView get(UUID id);

    List<CarView> getAll();

    CarView update(UUID id, CarUpdateRequest request);

    Boolean delete(UUID id);

}

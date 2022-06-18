package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.entity.Transmission;

public interface TransmissionAddRequestMapper {

    Transmission from(TransmissionAddRequest source);
}

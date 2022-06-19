package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.dto.request.TransmissionUpdateRequest;
import com.gavrish.automarket.model.dto.view.TransmissionView;
import com.gavrish.automarket.model.entity.Transmission;

public interface TransmissionMapper {

    Transmission from(TransmissionAddRequest source);

    TransmissionView from(Transmission source);

//    Transmission merge(Transmission target, TransmissionUpdateRequest source);

}

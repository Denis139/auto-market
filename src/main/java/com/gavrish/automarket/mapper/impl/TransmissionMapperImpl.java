package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.TransmissionAddRequestMapper;
import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.entity.Transmission;
import org.springframework.stereotype.Service;

@Service
public class TransmissionMapperImpl implements TransmissionAddRequestMapper {

    @Override
    public Transmission from(TransmissionAddRequest source) {
        return new Transmission()
                .setTransmissionType(source.getTransmissionTypeEnum())
                .setNumberGears(source.getNumberGears());
    }
}

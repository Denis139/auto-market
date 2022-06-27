package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.TransmissionMapper;
import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.dto.request.TransmissionUpdateRequest;
import com.gavrish.automarket.model.dto.view.TransmissionView;
import com.gavrish.automarket.model.entity.Transmission;
import org.springframework.stereotype.Service;

@Service
public class TransmissionMapperImpl implements TransmissionMapper {

    @Override
    public Transmission from(TransmissionAddRequest source) {
        return new Transmission()
                .setName(source.getName())
                .setTransmissionType(source.getTransmissionType())
                .setNumberGears(source.getNumberGears());
    }

    @Override
    public TransmissionView from(Transmission source) {
        return new TransmissionView()
                .setId(source.getId())
                .setTransmissionTypeEnum(source.getTransmissionType())
                .setNumberGears(source.getNumberGears());
    }
}

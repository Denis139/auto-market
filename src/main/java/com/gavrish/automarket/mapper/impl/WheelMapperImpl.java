package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.WheelAddRequestMapper;
import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.entity.Wheel;
import org.springframework.stereotype.Service;

@Service
public class WheelMapperImpl implements WheelAddRequestMapper {

    @Override
    public Wheel from(WheelAddRequest source) {
        return new Wheel()
                .setDiameter(source.getDiameter())
                .setWidth(source.getWidth())
                .setNumberHoles(source.getNumberHoles())
                .setBoltPattern(source.getBoltPattern())
                .setWeight(source.getWeight());
    }
}

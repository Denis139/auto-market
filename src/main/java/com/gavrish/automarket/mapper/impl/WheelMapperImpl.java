package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.WheelMapper;
import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.dto.request.WheelUpdateRequest;
import com.gavrish.automarket.model.dto.view.WheelView;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.Wheel;
import org.springframework.stereotype.Service;

@Service()
public class WheelMapperImpl implements WheelMapper {

    @Override
    public Wheel from(WheelAddRequest source) {
        return new Wheel()
                .setName(source.getName())
                .setDiameter(source.getDiameter())
                .setWidth(source.getWidth())
                .setNumberHoles(source.getNumberHoles())
                .setBoltPattern(source.getBoltPattern())
                .setWeight(source.getWeight());
    }

    @Override
    public WheelView from(Wheel source) {
        return new WheelView()
                .setName(source.getName())
                .setId(source.getId())
                .setDiameter(source.getDiameter())
                .setWidth(source.getWidth())
                .setNumberHoles(source.getNumberHoles())
                .setBoltPattern(source.getBoltPattern())
                .setWeight(source.getWeight());
    }

    @Override
    public Wheel merge(Wheel target, WheelUpdateRequest source) {
        return target
                .setDiameter(source.getDiameter() == null ? target.getDiameter() : source.getDiameter());
    }
}

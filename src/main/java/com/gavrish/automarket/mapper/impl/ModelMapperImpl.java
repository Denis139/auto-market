package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.ModelAddRequestMapper;
import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.entity.Engine;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.Transmission;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperImpl implements ModelAddRequestMapper {

    @Override
    public Model from(ModelAddRequest source, Engine engine, Transmission transmission) {
        return new Model()
                .setName(source.getName())
                .setDriveTrain(source.getDriveTrain())
                .setFuelConsumption(source.getFuelConsumption())
                .setColor(source.getColor())
                .setEngine(engine)
                .setTransmission(transmission);
    }
}

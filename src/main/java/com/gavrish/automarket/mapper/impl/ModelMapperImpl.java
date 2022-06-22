package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.ModelMapper;
import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.dto.request.ModelUpdateRequest;
import com.gavrish.automarket.model.dto.view.ModelView;
import com.gavrish.automarket.model.entity.Engine;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.Transmission;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperImpl implements ModelMapper {

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

    @Override
    public ModelView from(Model source) {
        return new ModelView()
                .setId(source.getId())
                .setName(source.getName())
                .setDriveTrain(source.getDriveTrain())
                .setFuelConsumption(source.getFuelConsumption())
                .setColor(source.getColor())
                .setTransmission(source.getTransmission())
                .setEngine(source.getEngine());
    }

    @Override
    public Model merge(Model target, ModelUpdateRequest source) {
        return target
                .setDriveTrain(source.getDriveTrain() == null? target.getDriveTrain() : source.getDriveTrain())
                .setColor(source.getColor() == null? target.getColor() : source.getColor());
    }
}

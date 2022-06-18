package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.EngineMapper;
import com.gavrish.automarket.model.dto.request.EngineAddRequest;
import com.gavrish.automarket.model.dto.request.EngineUpdateRequest;
import com.gavrish.automarket.model.dto.view.EngineView;
import com.gavrish.automarket.model.entity.Engine;
import org.springframework.stereotype.Service;

@Service
public class EngineMapperImpl implements EngineMapper {

    @Override
    public Engine from(EngineAddRequest source) {
        return new Engine()
                .setName(source.getName())
                .setEngineType(source.getEngineTypeEnum())
                .setVolume(source.getVolume())
                .setPower(source.getPower())
                .setTorque(source.getTorque())
                .setFuel(source.getFuel())
                .setWarranty(source.getWarranty());
    }

    @Override
    public EngineView from(Engine source) {
        return new EngineView()
                .setId(source.getId())
                .setEngineType(source.getEngineType())
                .setVolume(source.getVolume())
                .setPower(source.getPower())
                .setTorque(source.getTorque())
                .setFuel(source.getFuel())
                .setWarranty(source.getWarranty());
    }

    @Override
    public Engine merge(Engine target, EngineUpdateRequest source) {
        return target
                .setName(source.getName() == null ? target.getName() : source.getName())
                .setWarranty(source.getWarranty() == null ? target.getWarranty() : source.getWarranty());
    }
}

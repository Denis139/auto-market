package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.FactoryMapper;
import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.dto.request.FactoryUpdateRequest;
import com.gavrish.automarket.model.dto.view.FactoryView;
import com.gavrish.automarket.model.entity.Factory;
import org.springframework.stereotype.Service;

@Service
public class FactoryMapperImpl implements FactoryMapper {

    @Override
    public Factory from(FactoryAddRequest source) {
        return new Factory()
                .setFactoryName(source.getFactoryName())
                .setCountry(source.getCountry())
                .setRegion(source.getRegion())
                .setCity(source.getCity())
                .setEmployees(source.getEmployees());
    }

    @Override
    public FactoryView from(Factory source) {
        return new FactoryView()
                .setFactoryName(source.getFactoryName())
                .setCountry(source.getCountry())
                .setRegion(source.getRegion())
                .setCity(source.getCity())
                .setEmployees(source.getEmployees());
    }

    @Override
    public Factory merge(Factory target, FactoryUpdateRequest source) {
        return target
                .setFactoryName(source.getFactoryName() == null ? target.getFactoryName() : source.getFactoryName())
                .setCountry(source.getCountry() == null ? target.getCountry() : source.getFactoryName())
                .setEmployees(source.getEmployees() == null ? target.getEmployees() : source.getEmployees());
    }
}

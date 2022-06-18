package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.FactoryAddRequestMapper;
import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.entity.Factory;
import org.springframework.stereotype.Service;

@Service
public class FactoryMapperImpl implements FactoryAddRequestMapper {

    @Override
    public Factory from(FactoryAddRequest source) {
        return new Factory()
                .setFactoryName(source.getFactoryName())
                .setCountry(source.getCountry())
                .setRegion(source.getRegion())
                .setCity(source.getCity())
                .setEmployees(source.getEmployees());
    }
}

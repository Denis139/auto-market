package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.CarAddRequestMapper;
import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.entity.Car;
import org.springframework.stereotype.Service;

@Service
public class CarMapperImpl implements CarAddRequestMapper {

    @Override
    public Car from(CarAddRequest source) {
        return new Car()
                .setBrand(source.getBrand())
                .setYearOfIssue(source.getYearOfIssue())
                .setMileage(source.getMileage())
                .setPrice(source.getPrice());
//                .setModel(source.getModelId());                        // выдает ошибку
    }
}

//  мы создали новую сущность в базе дынных.
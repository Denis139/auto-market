package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.CarMapper;
import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.dto.request.CarUpdateRequest;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Car;
import com.gavrish.automarket.model.entity.Model;
import org.springframework.stereotype.Service;

@Service
public class CarMapperImpl implements CarMapper {

    @Override
    public Car from(CarAddRequest source, Model model) {
        return new Car()
                .setBrand(source.getBrand())
                .setYearOfIssue(source.getYearOfIssue())
                .setMileage(source.getMileage())
                .setPrice(source.getPrice())
                .setModel(model);
    }

    @Override
    public CarView from(Car source) {
        return new CarView()
                .setId(source.getId())
                .setBrand(source.getBrand())
                .setYearOfIssue(source.getYearOfIssue())
                .setMileage(source.getMileage())
                .setPrice(source.getPrice())
                .setModelId(source.getModel().getId());
    }

    @Override
    public Car merge(Car target, CarUpdateRequest source) {
        return target
                .setMileage(source.getMileage() == null ? target.getMileage() : source.getMileage())
                .setPrice(source.getPrice() == null ? target.getPrice() : source.getPrice());
    }
}
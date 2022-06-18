package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.entity.Car;

public interface CarAddRequestMapper {

    Car from(CarAddRequest source);
}

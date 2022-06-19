package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.dto.request.CarUpdateRequest;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Car;

public interface CarMapper {

    Car from(CarAddRequest source);

    CarView from(Car source);

    Car merge(Car target, CarUpdateRequest source);
}

package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.dto.request.CarUpdateRequest;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Car;
import com.gavrish.automarket.model.entity.Model;
import java.util.Collection;
import java.util.List;

public interface CarMapper {

    Car from(CarAddRequest source, Model model);

    CarView from(Car source);

    default List<CarView> from(Collection<Car> source) {
        return source
                .stream()
                .map(o -> from(o))
                .toList();
    }

    Car merge(Car target, CarUpdateRequest source);
}

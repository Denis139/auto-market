package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.entity.Factory;

public interface FactoryAddRequestMapper {

    Factory from(FactoryAddRequest source);
}

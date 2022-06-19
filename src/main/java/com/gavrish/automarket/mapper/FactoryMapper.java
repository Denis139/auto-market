package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.dto.request.FactoryUpdateRequest;
import com.gavrish.automarket.model.dto.view.FactoryView;
import com.gavrish.automarket.model.entity.Factory;

public interface FactoryMapper {

    Factory from(FactoryAddRequest source);

    FactoryView from(Factory source);

    Factory merge(Factory target, FactoryUpdateRequest source);

}

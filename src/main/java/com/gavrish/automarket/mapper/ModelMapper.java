package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.dto.request.ModelUpdateRequest;
import com.gavrish.automarket.model.dto.view.ModelView;
import com.gavrish.automarket.model.entity.Engine;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.Transmission;
import com.gavrish.automarket.model.entity.Wheel;

public interface ModelMapper {

    Model from(ModelAddRequest source, Engine engine, Transmission transmission, Wheel wheel);

    ModelView from(Model source);

    Model merge(Model target, ModelUpdateRequest source);
}

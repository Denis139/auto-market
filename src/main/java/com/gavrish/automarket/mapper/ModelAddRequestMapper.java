package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.entity.Engine;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.Transmission;

public interface ModelAddRequestMapper {

    Model from(ModelAddRequest source, Engine engine, Transmission transmission);
}

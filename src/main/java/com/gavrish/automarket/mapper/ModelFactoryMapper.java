package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.entity.Factory;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.ModelFactory;

public interface ModelFactoryMapper {

    ModelFactory from(Model model, Factory factory);
}

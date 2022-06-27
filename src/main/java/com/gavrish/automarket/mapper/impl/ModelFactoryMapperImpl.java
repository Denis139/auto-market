package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.ModelFactoryMapper;
import com.gavrish.automarket.model.entity.Factory;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.ModelFactory;
import org.springframework.stereotype.Service;

@Service()
public class ModelFactoryMapperImpl implements ModelFactoryMapper {

    @Override
    public ModelFactory from(Model model, Factory factory) {
        return new ModelFactory()
                .setModel(model)
                .setFactory(factory);
    }
}

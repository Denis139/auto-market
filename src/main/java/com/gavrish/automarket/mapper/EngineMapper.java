package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.EngineAddRequest;
import com.gavrish.automarket.model.dto.request.EngineUpdateRequest;
import com.gavrish.automarket.model.dto.view.EngineView;
import com.gavrish.automarket.model.entity.Engine;

public interface EngineMapper {

    Engine from(EngineAddRequest source);            // метод, который создает Енжин из Реквест. Чтобы создать запись в базе данных.

    EngineView from(Engine source);

    Engine merge(Engine target, EngineUpdateRequest source);
}

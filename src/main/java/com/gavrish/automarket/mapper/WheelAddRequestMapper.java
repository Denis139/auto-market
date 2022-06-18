package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.entity.Wheel;

public interface WheelAddRequestMapper {

  Wheel from(WheelAddRequest source);

}

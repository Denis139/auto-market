package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.dto.request.WheelUpdateRequest;
import com.gavrish.automarket.model.dto.view.WheelView;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.Wheel;

public interface WheelMapper {

  Wheel from(WheelAddRequest source);

  WheelView from(Wheel source);

  Wheel merge(Wheel target, WheelUpdateRequest source);

}

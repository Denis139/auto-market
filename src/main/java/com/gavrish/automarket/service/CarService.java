package com.gavrish.automarket.service;

import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Brand;
import com.gavrish.automarket.model.entity.EngineTypeEnum;
import com.gavrish.automarket.model.entity.TransmissionTypeEnum;

import java.util.List;

public interface CarService {

    List<CarView> getAllByParams(Brand brand,
                                 String modelName,
                                 Integer yearOfIssueMin,
                                 Integer yearOfIssueMax,
                                 EngineTypeEnum engineType,
                                 Integer enginePowerMin,
                                 Integer enginePowerMax,
                                 Double engineVolumeMin,
                                 Double engineVolumeMax,
                                 TransmissionTypeEnum transmissionType);

    List<CarView> getAllByCarParams(String factoryName);

    List<CarView> getAllByEngineParams(String factoryName);
}

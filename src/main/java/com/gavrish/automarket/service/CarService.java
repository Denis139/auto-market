package com.gavrish.automarket.service;

import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Brand;
import com.gavrish.automarket.model.entity.EngineTypeEnum;
import com.gavrish.automarket.model.entity.TransmissionTypeEnum;

import java.math.BigDecimal;
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

    List<CarView> getCarsByFactory(String factoryName);

    List<CarView> getCarsByEngine(String name);

    public List<CarView> getCarsByTransmission(String name);

    public List<CarView> getCarsByMinParams(Brand brand,
                                            String modelName,
                                            EngineTypeEnum engineType,
                                            TransmissionTypeEnum transmissionType,
                                            Long mileage,
                                            BigDecimal price);
}

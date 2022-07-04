package com.gavrish.automarket.service.CarService;

import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Brand;
import com.gavrish.automarket.model.entity.EngineTypeEnum;
import com.gavrish.automarket.model.entity.TransmissionTypeEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
}

package com.gavrish.automarket.service.CarService.CarServiceImpl;

import com.gavrish.automarket.mapper.CarMapper;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Brand;
import com.gavrish.automarket.model.entity.EngineTypeEnum;
import com.gavrish.automarket.model.entity.TransmissionTypeEnum;
import com.gavrish.automarket.repository.CarRepository;
import com.gavrish.automarket.repository.ModelRepository;
import com.gavrish.automarket.service.CarService.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelRepository modelRepository;

    private final CarMapper carMapper;

    @Override
    @Transactional
    public List<CarView> getAllByParams(Brand brand,
                                        String modelName,
                                        Integer yearOfIssueMin,
                                        Integer yearOfIssueMax,
                                        EngineTypeEnum engineType,
                                        Integer enginePowerMin,
                                        Integer enginePowerMax,
                                        Double engineVolumeMin,
                                        Double engineVolumeMax,
                                        TransmissionTypeEnum transmissionType) {

        var cars = carRepository.findAllByBrandAndModel(brand, modelRepository.findByName(modelName));

        if (yearOfIssueMin == null)
            yearOfIssueMin = 1950;
        if (yearOfIssueMax == null)
            yearOfIssueMax = 2022;
        if (enginePowerMin == null)
            enginePowerMin = 1;
        if (enginePowerMax == null)
            enginePowerMax = 3000;
        if (engineVolumeMin == null)
            engineVolumeMin = 0.1;
        if (engineVolumeMax == null)
            engineVolumeMax = 16.0;

        var finalYearOfIssueMin = yearOfIssueMin;
        var finalYearOfIssueMax = yearOfIssueMax;
        var finalEnginePowerMin = enginePowerMin;
        var finalEnginePowerMax = enginePowerMax;
        var finalEngineVolumeMin = engineVolumeMin;
        var finalEngineVolumeMax = engineVolumeMax;
        cars = cars.stream()
                .filter(o -> o.getYearOfIssue() >= finalYearOfIssueMin && o.getYearOfIssue() <= finalYearOfIssueMax)
                .filter(o -> o.getModel().getEngine().getPower() >= finalEnginePowerMin && o.getModel().getEngine().getPower() <= finalEnginePowerMax)
                .filter(o -> o.getModel().getEngine().getVolume() >= finalEngineVolumeMin && o.getModel().getEngine().getVolume() <= finalEngineVolumeMax)
                .toList();

        if (engineType != null) {
            cars = cars.stream()
                    .filter(o -> o.getModel().getEngine().getEngineType().equals(engineType))
                    .toList();
        }

        if (transmissionType != null) {
            cars = cars.stream()
                    .filter(o -> o.getModel().getTransmission().getTransmissionType().equals(transmissionType))
                    .toList();
        }

        return carMapper.from(cars);
    }
}



//    var car = carRepository.findAll()
//            .stream()
//            .filter(o->o.getBrand().equals(brand))
////                .filter(o->o.getModel().getName().equals(modelName))
//            .filter(o->o.getYearOfIssue().isAfter(yearOfIssueMin) || o.getYearOfIssue().isBefore(yearOfIssueMax))
//            .map(o->carMapper.from(o))
//            .toList();
//
//    var engine = engineRepository.findAll()
//            .stream()
//            .filter(o->o.getEngineType().equals(engineType))
//            .filter(o->o.getPower().equals(enginePowerMin))
//            .filter(o->o.getPower().equals(enginePowerMax))
//            .filter(o->o.getVolume().equals(engineVolumeMin))
//            .filter(o->o.getVolume().equals(engineVolumeMax))
//            .map(o->engineMapper.from(o));
////                .toList();
//
//    var transmission = transmissionRepository.findAll()
//            .stream()
//            .filter(o->o.getTransmissionType().equals(transmissionType))
//            .map(o->transmissionMapper.from(o));
//                .toList();
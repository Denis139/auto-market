package com.gavrish.automarket.service.impl;

import com.gavrish.automarket.mapper.CarMapper;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.*;
import com.gavrish.automarket.repository.CarRepository;
import com.gavrish.automarket.repository.EngineRepository;
import com.gavrish.automarket.repository.FactoryRepository;
import com.gavrish.automarket.repository.ModelRepository;
import com.gavrish.automarket.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelRepository modelRepository;
    private final FactoryRepository factoryRepository;
    private final EngineRepository engineRepository;

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

        var model = modelRepository.findByName(modelName);
        var cars = carRepository.findAllByBrandAndModel(brand, model);

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

    @Override
    @Transactional
    public List<CarView> getAllByCarParams(String factoryName) {
        var factory = factoryRepository.findByFactoryName(factoryName);
        var cars = factory.getModelFactories()
                .stream()
                .map(ModelFactory::getModel)
                .toList()
                .stream()
                .map(Model::getCars)
                .flatMap(List::stream)
                .toList();

        return carMapper.from(cars);
    }

    @Override
    @Transactional
    public List<CarView> getAllByEngineParams(String name) {
        var engine = engineRepository.findByName(name);
        var cars = engine.getModels()
                .stream()
                .map(Model::getCars)
                .flatMap(List::stream)
                .toList();

        return carMapper.from(cars);
    }
}
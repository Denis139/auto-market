package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.CarMapper;
import com.gavrish.automarket.mapper.ModelMapper;
import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.dto.request.CarUpdateRequest;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.model.entity.Car;
import com.gavrish.automarket.repository.CarRepository;
import com.gavrish.automarket.repository.ModelRepository;
import com.gavrish.automarket.service.domain.CarDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarDomainServiceImpl implements CarDomainService {

    private final CarMapper carMapper;

    private final CarRepository carRepository;

    private final ModelRepository modelRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(CarAddRequest request) {

        var model = modelRepository.getById(request.getModelId());
        var car = carMapper.from(request, model);
        car = carRepository.saveAndFlush(car);
        return car.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public CarView get(UUID id) {
        return carMapper.from(findById(id));
    }

    @Override
    public List<CarView> getAll() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::from)
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CarView update(UUID id, CarUpdateRequest request) {

        var car = findById(id);
        car = carMapper.merge(car, request);
        car = carRepository.saveAndFlush(car);
        return carMapper.from(car);
    }

    @Override
    public Boolean delete(UUID id) {
        var car = findById(id);
        carRepository.delete(car);
        carRepository.flush();
        return !carRepository.existsById(id);
    }

    private Car findById(UUID id) {
        return carRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Engine with id [%s] not found", id)));
    }
}
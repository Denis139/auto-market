package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.CarAddRequestMapper;
import com.gavrish.automarket.model.dto.request.CarAddRequest;
import com.gavrish.automarket.model.dto.request.CarUpdateRequest;
import com.gavrish.automarket.model.dto.view.CarView;
import com.gavrish.automarket.repository.CarRepository;
import com.gavrish.automarket.service.domain.CarDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarDomainServiceImpl implements CarDomainService {

    private final CarAddRequestMapper carAddRequestMapper;

    private final CarRepository carRepository;         //          ?????

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(CarAddRequest request) {
        var car = carAddRequestMapper.from(request);
        car = carRepository.saveAndFlush(car);
        return car.getId();
    }

    @Override
    public CarView get(UUID id) {
        return null;
    }

    @Override
    public List<CarView> getAll() {
        return null;
    }

    @Override
    public CarView update(CarUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {
    }
}
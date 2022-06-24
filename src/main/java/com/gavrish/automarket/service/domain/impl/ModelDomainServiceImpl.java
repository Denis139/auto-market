package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.ModelFactoryMapper;
import com.gavrish.automarket.mapper.ModelMapper;
import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.dto.request.ModelUpdateRequest;
import com.gavrish.automarket.model.dto.view.ModelView;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.model.entity.Wheel;
import com.gavrish.automarket.repository.*;
import com.gavrish.automarket.service.domain.ModelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModelDomainServiceImpl implements ModelDomainService {

    private final ModelMapper modelMapper;
    private final ModelFactoryMapper modelFactoryMapper;
    private final ModelRepository modelRepository;
    private final EngineRepository engineRepository;
    private final TransmissionRepository transmissionRepository;
    private final WheelRepository wheelRepository;
    private final FactoryRepository factoryRepository;
    private final ModelFactoryRepository modelFactoryRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(ModelAddRequest request) {

        var engine = engineRepository.findById(request.getEngineId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Engine with id: %s not found", request.getEngineId())));

        var transmission = transmissionRepository.findById(request.getTransmissionId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Transmission with id: %s not found", request.getTransmissionId())));

        var wheel = wheelRepository.findById(request.getWheelId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Wheel with id: %s not found", request.getWheelId())));

        var model = modelMapper.from(request, engine, transmission, wheel);
        var savedModel = modelRepository.saveAndFlush(model);

        var factories = factoryRepository.findAllById(request.getFactoryIds());

        var modelFactories = factories
                .stream()
                .map(o -> modelFactoryMapper.from(savedModel, o))
                .toList();

        modelFactoryRepository.saveAllAndFlush(modelFactories);

        return model.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public ModelView get(UUID id) {
        return modelMapper.from(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ModelView> getAll() {
        return modelRepository.findAll()
                .stream()
                .map(modelMapper::from)
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ModelView update(UUID id, ModelUpdateRequest request) {
        var model = findById(id);
        model = modelMapper.merge(model, request);
        modelRepository.saveAndFlush(model);
        return modelMapper.from(model);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var model = findById(id);
        modelRepository.delete(model);
        modelRepository.flush();
        return !modelRepository.existsById(id);
    }

    private Model findById(UUID id) {
        return modelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Model with id [%s] not found", id)));
    }
}

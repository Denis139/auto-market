package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.ModelMapper;
import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.dto.request.ModelUpdateRequest;
import com.gavrish.automarket.model.dto.view.ModelView;
import com.gavrish.automarket.model.entity.Model;
import com.gavrish.automarket.repository.EngineRepository;
import com.gavrish.automarket.repository.ModelRepository;
import com.gavrish.automarket.repository.ModelWheelRepository;
import com.gavrish.automarket.repository.TransmissionRepository;
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
    private final ModelRepository modelRepository;
    private final EngineRepository engineRepository;
    private final TransmissionRepository transmissionRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(ModelAddRequest request) {

        var engine = engineRepository.getById(request.getEngineId());
        var transmission = transmissionRepository.getById(request.getTransmissionId());
        var model = modelMapper.from(request, engine, transmission);
        model = modelRepository.saveAndFlush(model);
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

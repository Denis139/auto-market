package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.ModelAddRequestMapper;
import com.gavrish.automarket.model.dto.request.ModelAddRequest;
import com.gavrish.automarket.model.dto.request.ModelUpdateRequest;
import com.gavrish.automarket.model.dto.view.ModelView;
import com.gavrish.automarket.repository.EngineRepository;
import com.gavrish.automarket.repository.ModelRepository;
import com.gavrish.automarket.repository.TransmissionRepository;
import com.gavrish.automarket.service.domain.ModelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModelDomainServiceImpl implements ModelDomainService {

    private final ModelAddRequestMapper modelAddRequestMapper;

    private final ModelRepository modelRepository;
    private final EngineRepository engineRepository;
    private final TransmissionRepository transmissionRepository;

    @Override
    public UUID add(ModelAddRequest request) {

        var engine = engineRepository.getById(request.getEngineId());
        var transmission = transmissionRepository.getById(request.getTransmissionId());

        var model = modelAddRequestMapper.from(request, engine, transmission);
        model = modelRepository.saveAndFlush(model);
        return model.getId();
    }

    @Override
    public ModelView get(UUID id) {
        return null;
    }

    @Override
    public List<ModelView> getAll() {
        return null;
    }

    @Override
    public ModelView update(ModelUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}

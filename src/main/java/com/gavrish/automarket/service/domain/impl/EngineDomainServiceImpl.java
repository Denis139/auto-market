package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.EngineMapper;
import com.gavrish.automarket.model.dto.request.EngineAddRequest;
import com.gavrish.automarket.model.dto.request.EngineUpdateRequest;
import com.gavrish.automarket.model.dto.view.EngineView;
import com.gavrish.automarket.model.entity.Engine;
import com.gavrish.automarket.repository.EngineRepository;
import com.gavrish.automarket.service.domain.EngineDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EngineDomainServiceImpl implements EngineDomainService {

    private final EngineRepository engineRepository;

    private final EngineMapper engineMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(EngineAddRequest request) {
        /*if (Boolean.TRUE.equals(engineRepository.existsByName(request.getName()))) {
            throw new EntityExistsException(String.format("Engine with name [%s] already exist", request.getName()));
        }*/

        var engine = engineMapper.from(request);
        engine = engineRepository.saveAndFlush(engine);

        return engine.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public EngineView get(UUID id) {
        return engineMapper.from(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EngineView> getAll() {
        return engineRepository.findAll()
                .stream()
                .map(o -> engineMapper.from(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EngineView update(UUID id, EngineUpdateRequest request) {

        var engine = findById(id);
        engine = engineMapper.merge(engine, request);
        engine = engineRepository.saveAndFlush(engine);

        return engineMapper.from(engine);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {

        var engine = findById(id);
        engineRepository.delete(engine);
        engineRepository.flush();

        return !engineRepository.existsById(id);
    }

    private Engine findById(UUID id) {
        return engineRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Engine with id [%s] not found", id)));
    }
}



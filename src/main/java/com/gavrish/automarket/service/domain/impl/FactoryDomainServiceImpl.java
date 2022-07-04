package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.FactoryMapper;
import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.dto.request.FactoryUpdateRequest;
import com.gavrish.automarket.model.dto.view.FactoryView;
import com.gavrish.automarket.model.entity.Factory;
import com.gavrish.automarket.repository.FactoryRepository;
import com.gavrish.automarket.service.domain.FactoryDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FactoryDomainServiceImpl implements FactoryDomainService {

    private final FactoryRepository factoryRepository;

    private final FactoryMapper factoryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(FactoryAddRequest request) {
        log.info("add");

        var factory = factoryMapper.from(request);
        factory = factoryRepository.saveAndFlush(factory);

        log.info("end");
        return factory.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public FactoryView get(UUID id) {
        return factoryMapper.from(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FactoryView> getAll() {
        return factoryRepository.findAll()
                .stream()
                .map(o -> factoryMapper.from(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FactoryView update(UUID id, FactoryUpdateRequest request) {

        var factory = findById(id);
        factory = factoryMapper.merge(factory, request);
        factory = factoryRepository.saveAndFlush(factory);

        return factoryMapper.from(factory);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var factory = findById(id);
        factoryRepository.delete(factory);
        factoryRepository.flush();
        return !factoryRepository.existsById(id);
    }

    private Factory findById(UUID id) {
        return factoryRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Engine with id [%s] not found", id)));
    }
}

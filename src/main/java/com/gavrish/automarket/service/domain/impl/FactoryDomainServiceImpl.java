package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.FactoryAddRequestMapper;
import com.gavrish.automarket.model.dto.request.FactoryAddRequest;
import com.gavrish.automarket.model.dto.request.FactoryUpdateRequest;
import com.gavrish.automarket.model.dto.view.FactoryView;
import com.gavrish.automarket.repository.FactoryRepository;
import com.gavrish.automarket.service.domain.FactoryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FactoryDomainServiceImpl implements FactoryDomainService {

    private final FactoryRepository factoryRepository;

    private final FactoryAddRequestMapper factoryAddRequestMapper;

    @Override
    public UUID add(FactoryAddRequest request) {
        var factory = factoryAddRequestMapper.from(request);
        factory = factoryRepository.saveAndFlush(factory);
        return factory.getId();
    }

    @Override
    public FactoryView get(UUID id) {
        return null;
    }

    @Override
    public List<FactoryView> getAll() {
        return null;
    }

    @Override
    public FactoryView update(FactoryUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}

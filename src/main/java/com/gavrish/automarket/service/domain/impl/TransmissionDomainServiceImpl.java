package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.TransmissionAddRequestMapper;
import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.dto.request.TransmissionUpdateRequest;
import com.gavrish.automarket.model.dto.view.TransmissionView;
import com.gavrish.automarket.repository.TransmissionRepository;
import com.gavrish.automarket.service.domain.TransmissionDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransmissionDomainServiceImpl implements TransmissionDomainService {

    private final TransmissionRepository transmissionRepository;

    private final TransmissionAddRequestMapper transmissionAddRequestMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(TransmissionAddRequest request) {
        var transmission = transmissionAddRequestMapper.from(request);
        transmission = transmissionRepository.saveAndFlush(transmission);
        return transmission.getId();
    }

    @Override
    public TransmissionView get(UUID id) {
        return null;
    }

    @Override
    public List<TransmissionView> getAll() {
        return null;
    }

    @Override
    public TransmissionView update(TransmissionUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {
    }
}

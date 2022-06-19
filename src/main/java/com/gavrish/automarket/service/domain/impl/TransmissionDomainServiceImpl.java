package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.TransmissionMapper;
import com.gavrish.automarket.model.dto.request.TransmissionAddRequest;
import com.gavrish.automarket.model.dto.request.TransmissionUpdateRequest;
import com.gavrish.automarket.model.dto.view.TransmissionView;
import com.gavrish.automarket.model.entity.Transmission;
import com.gavrish.automarket.repository.TransmissionRepository;
import com.gavrish.automarket.service.domain.TransmissionDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransmissionDomainServiceImpl implements TransmissionDomainService {

    private final TransmissionRepository transmissionRepository;

    private final TransmissionMapper transmissionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(TransmissionAddRequest request) {
        var transmission = transmissionMapper.from(request);
        transmission = transmissionRepository.saveAndFlush(transmission);
        return transmission.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public TransmissionView get(UUID id) {
        return transmissionMapper.from(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransmissionView> getAll() {
        return transmissionRepository.findAll()
                .stream()
                .map(o -> transmissionMapper.from(o))
                .toList();
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public TransmissionView update(UUID id, TransmissionUpdateRequest request) {
//        var transmission = findById(id);
//        transmission = transmissionMapper.merge(transmission, request);
//        transmission = transmissionRepository.saveAndFlush(transmission);
//        return transmissionMapper.from(transmission);
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var transmission = findById(id);
        transmissionRepository.delete(transmission);
        transmissionRepository.flush();
        return !transmissionRepository.existsById(id);
    }

    private Transmission findById(UUID id) {
        return transmissionRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Transmission with id [%s] not found", id)));
    }
}

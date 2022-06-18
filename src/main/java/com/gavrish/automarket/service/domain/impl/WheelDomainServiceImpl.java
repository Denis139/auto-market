package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.WheelAddRequestMapper;
import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.dto.request.WheelUpdateRequest;
import com.gavrish.automarket.model.dto.view.WheelView;
import com.gavrish.automarket.repository.WheelRepository;
import com.gavrish.automarket.service.domain.WheelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WheelDomainServiceImpl implements WheelDomainService {

    private final WheelRepository wheelRepository;

    private final WheelAddRequestMapper wheelAddRequestMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(WheelAddRequest request) {                  ///???????
        var wheel = wheelAddRequestMapper.from(request);
        wheel = wheelRepository.saveAndFlush(wheel);
        return wheel.getId();
    }

    @Override
    public WheelView get(UUID id) {
        return null;
    }

    @Override
    public List<WheelView> getAll() {
        return null;
    }

    @Override
    public WheelView update(WheelUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
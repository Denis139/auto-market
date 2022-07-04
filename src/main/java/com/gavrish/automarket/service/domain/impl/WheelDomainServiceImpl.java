package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.WheelMapper;
import com.gavrish.automarket.model.dto.request.WheelAddRequest;
import com.gavrish.automarket.model.dto.request.WheelUpdateRequest;
import com.gavrish.automarket.model.dto.view.WheelView;
import com.gavrish.automarket.model.entity.Wheel;
import com.gavrish.automarket.repository.ModelRepository;
import com.gavrish.automarket.repository.WheelRepository;
import com.gavrish.automarket.service.domain.WheelDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WheelDomainServiceImpl implements WheelDomainService {

    private final WheelRepository wheelRepository;

    private final WheelMapper wheelMapper;

    private final ModelRepository modelRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(WheelAddRequest request) {                  ///???????
        var wheel = wheelMapper.from(request);
        wheel = wheelRepository.saveAndFlush(wheel);
        return wheel.getId();
    }

    @Override
    public WheelView get(UUID id) {
        return wheelMapper.from(findById(id));
    }

    @Override
    public List<WheelView> getAll() {
        return wheelRepository.findAll()
                .stream()
                .map(o -> wheelMapper.from(o))
                .toList();
    }

    @Override
    public WheelView update(UUID id, WheelUpdateRequest request) {

        var wheel = findById(id);

        wheel = wheelMapper.merge(wheel, request);
        wheel = wheelRepository.saveAndFlush(wheel);

        return wheelMapper.from(wheel);
    }

    @Override
    public Boolean delete(UUID id) {
        var wheel = findById(id);
        wheelRepository.delete(wheel);
        wheelRepository.flush();
        return !wheelRepository.existsById(id);
    }

   private Wheel findById(UUID id) {
        return wheelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Engine with id [%s] not found", id)));
   }
}
package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.RoleMapper;
import com.gavrish.automarket.model.dto.request.RoleAddRequest;
import com.gavrish.automarket.model.dto.view.RoleView;
import com.gavrish.automarket.model.entity.Role;
import com.gavrish.automarket.repository.RoleRepository;
import com.gavrish.automarket.service.domain.RoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleDomainServiceImpl implements RoleDomainService {

    private RoleRepository roleRepository;

    private RoleMapper roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(RoleAddRequest request) {
       var role = roleMapper.from(request);
        role = roleRepository.saveAndFlush(role);

        return role.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public RoleView get(UUID id) {
        return roleMapper.from(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleView> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(o -> roleMapper.from(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var role = findById(id);
        roleRepository.delete(role);
        roleRepository.flush();
        return !roleRepository.existsById(id);
    }

    private Role findById(UUID id) {
        return roleRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Role with id [%s] not found", id)));
    }
}

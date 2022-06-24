package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.RoleMapper;
import com.gavrish.automarket.mapper.UserMapper;
import com.gavrish.automarket.mapper.UserRoleMapper;
import com.gavrish.automarket.model.dto.request.UserAddRequest;
import com.gavrish.automarket.model.dto.view.UserView;
import com.gavrish.automarket.model.entity.User;
import com.gavrish.automarket.repository.RoleRepository;
import com.gavrish.automarket.repository.UserRepository;
import com.gavrish.automarket.repository.UserRoleRepository;
import com.gavrish.automarket.service.domain.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDomainServiceImpl implements UserDomainService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private RoleMapper roleMapper;

    private UserMapper userMapper;
    private UserRoleMapper userRoleMapper;
    private UserRoleRepository userRoleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(UserAddRequest request) {
        var user = userMapper.from(request);
        var newUser = userRepository.saveAndFlush(user);

        var roles = roleRepository.findAllById(request.getRoleIds());

        var userRole = roles
                .stream()
                .map(o -> userRoleMapper.from(newUser, o))
                .toList();
        userRoleRepository.saveAllAndFlush(userRole);

        return user.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public UserView get(UUID id) {
        return userMapper.from(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserView> getAll() {
        return userRepository.findAll()
                .stream()
                .map(o -> userMapper.from(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var user = findById(id);
        userRepository.delete(user);
        return !userRepository.existsById(id);
    }

    private User findById(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("User with id [%s] not found", id)));
    }
}

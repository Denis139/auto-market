package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.UserRoleMapper;
import com.gavrish.automarket.model.entity.Role;
import com.gavrish.automarket.model.entity.User;
import com.gavrish.automarket.model.entity.UserRole;
import org.springframework.stereotype.Service;

@Service
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRole from(User user, Role role) {
        return new UserRole()
                .setUser(user)
                .setRole(role);
    }
}

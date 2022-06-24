package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.RoleMapper;
import com.gavrish.automarket.model.dto.request.RoleAddRequest;
import com.gavrish.automarket.model.dto.view.RoleView;
import com.gavrish.automarket.model.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role from(RoleAddRequest source) {
        return new Role()
                .setRoleType(source.getRoleType())
                .setDescription(source.getDescription());
    }

    @Override
    public RoleView from(Role source) {
        return new RoleView()
                .setId(source.getId())
                .setRoleType(source.getRoleType())
                .setDescription(source.getDescription());
    }
}

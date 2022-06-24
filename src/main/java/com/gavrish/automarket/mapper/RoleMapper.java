package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.RoleAddRequest;
import com.gavrish.automarket.model.dto.view.RoleView;
import com.gavrish.automarket.model.entity.Role;

import java.util.List;

public interface RoleMapper {

        Role from(RoleAddRequest source);

        RoleView from(Role source);

    }


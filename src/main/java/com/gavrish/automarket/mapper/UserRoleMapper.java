package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.entity.Role;
import com.gavrish.automarket.model.entity.User;
import com.gavrish.automarket.model.entity.UserRole;

public interface UserRoleMapper {

    UserRole from(User user, Role role);

}

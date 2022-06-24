package com.gavrish.automarket.mapper;

import com.gavrish.automarket.model.dto.request.UserAddRequest;
import com.gavrish.automarket.model.dto.view.UserView;
import com.gavrish.automarket.model.entity.User;

public interface UserMapper {

    User from(UserAddRequest source);

    UserView from(User source);



}

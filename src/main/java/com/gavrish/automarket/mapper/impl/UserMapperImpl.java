package com.gavrish.automarket.mapper.impl;

import com.gavrish.automarket.mapper.UserMapper;
import com.gavrish.automarket.model.dto.request.UserAddRequest;
import com.gavrish.automarket.model.dto.view.UserView;
import com.gavrish.automarket.model.entity.User;
import org.springframework.stereotype.Service;

@Service()
public class UserMapperImpl implements UserMapper {

    @Override
    public User from(UserAddRequest source) {
        return new User()
                .setFirstname(source.getFirstname())
                .setLastname(source.getLastname())
                .setTelephoneNumber(source.getTelephoneNumber())
                .setEmail(source.getEmail());
    }

    @Override
    public UserView from(User source) {
        return new UserView()
                .setId(source.getId())
                .setFirstname(source.getFirstname())
                .setLastname(source.getLastname())
                .setTelephoneNumber(source.getTelephoneNumber())
                .setEmail(source.getEmail());
    }
}

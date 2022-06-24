package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.UserAddRequest;
import com.gavrish.automarket.model.dto.view.UserView;
import java.util.List;
import java.util.UUID;

public interface UserDomainService {

  UUID add(UserAddRequest request);

  UserView get(UUID id);

  List<UserView> getAll();

  Boolean delete(UUID id);

}

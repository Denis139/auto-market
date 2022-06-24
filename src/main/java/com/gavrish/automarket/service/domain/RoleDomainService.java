package com.gavrish.automarket.service.domain;

import com.gavrish.automarket.model.dto.request.RoleAddRequest;
import com.gavrish.automarket.model.dto.view.RoleView;
import java.util.List;
import java.util.UUID;

public interface RoleDomainService {

    UUID add(RoleAddRequest request);

    RoleView get(UUID id);

    List<RoleView> getAll();

    Boolean delete(UUID id);

}

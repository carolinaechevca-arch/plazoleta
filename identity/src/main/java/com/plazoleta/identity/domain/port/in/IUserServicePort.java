package com.plazoleta.identity.domain.port.in;


import com.plazoleta.identity.domain.enums.Role;
import com.plazoleta.identity.domain.model.User;

public interface IUserServicePort {

    User createUser(User user, Role role);
    User getUserById(Long id);
}

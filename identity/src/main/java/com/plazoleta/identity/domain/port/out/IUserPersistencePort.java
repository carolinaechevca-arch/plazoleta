package com.plazoleta.identity.domain.port.out;



import com.plazoleta.identity.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {
    User save(User user);
    boolean existsUserByEmail(String email);
    boolean existsUserByDni(String Dni);
    Optional<User> findById(Long id);

}

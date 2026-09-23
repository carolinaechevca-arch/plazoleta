package com.plazoleta.identity.infra.driven.out.jpa.adapter;

import com.plazoleta.identity.domain.model.User;
import com.plazoleta.identity.domain.port.out.IUserPersistencePort;
import com.plazoleta.identity.infra.driven.out.jpa.mapper.IUserEntityMapper;
import com.plazoleta.identity.infra.driven.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {
        return userEntityMapper.toModel(
                userRepository.save(userEntityMapper.toEntity(user))
        );
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsUserByDni(String dni) {
        return userRepository.existsByDni(dni);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id)
                .map(userEntityMapper::toModel);
    }
}
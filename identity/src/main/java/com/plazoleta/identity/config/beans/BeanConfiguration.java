package com.plazoleta.identity.config.beans;


import com.plazoleta.identity.domain.port.in.IUserServicePort;
import com.plazoleta.identity.domain.port.out.IUserPersistencePort;
import com.plazoleta.identity.domain.usecase.UserUseCase;
import com.plazoleta.identity.infra.driven.out.jpa.adapter.UserPersistenceAdapter;
import com.plazoleta.identity.infra.driven.out.jpa.mapper.IUserEntityMapper;
import com.plazoleta.identity.infra.driven.out.jpa.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {
//solid - d
    @Bean
    public IUserServicePort userUseCase(
            IUserPersistencePort userPersistencePort) {
        return new UserUseCase(userPersistencePort);
    }

    @Bean
    public IUserPersistencePort userPersistencePort(
            IUserRepository userRepository,
            IUserEntityMapper userEntityMapper) {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }


}
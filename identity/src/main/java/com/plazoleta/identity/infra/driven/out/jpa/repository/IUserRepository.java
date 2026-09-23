package com.plazoleta.identity.infra.driven.out.jpa.repository;

import com.plazoleta.identity.infra.driven.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    boolean existsByDni(String dni);
}
package com.plazoleta.identity.infra.driven.out.jpa.mapper;

import com.plazoleta.identity.domain.model.User;
import com.plazoleta.identity.infra.driven.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    UserEntity toEntity(User user);
    User toModel(UserEntity userEntity);
}
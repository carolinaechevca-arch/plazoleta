package com.plazoleta.identity.infra.driving.in.mapper;

import com.plazoleta.identity.domain.model.User;
import com.plazoleta.identity.infra.driving.in.dto.request.UserRequestDto;
import com.plazoleta.identity.infra.driving.in.dto.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserDtoMapper {

    User toUser(UserRequestDto request);
    UserResponseDto toResponse (User user);
}

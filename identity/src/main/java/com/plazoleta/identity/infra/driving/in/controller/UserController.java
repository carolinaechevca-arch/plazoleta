package com.plazoleta.identity.infra.driving.in.controller;

import com.plazoleta.identity.domain.enums.Role;
import com.plazoleta.identity.domain.port.in.IUserServicePort;
import com.plazoleta.identity.infra.driving.in.dto.request.UserRequestDto;
import com.plazoleta.identity.infra.driving.in.dto.response.UserResponseDto;
import com.plazoleta.identity.infra.driving.in.mapper.IUserDtoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "Endpoints para gestión de usuarios")
public class UserController {

    private final IUserServicePort userService; //inyeccion de dependencias
    private final IUserDtoMapper userMapper; //inyeccion de dependencias
    @PostMapping("/owner")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUserOwner(@Valid @RequestBody UserRequestDto userRequest) {
        return userMapper.toResponse(userService.createUser(userMapper.toUser(userRequest), Role.OWNER));
    }



    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userMapper.toResponse(userService.getUserById(id));
    }

}

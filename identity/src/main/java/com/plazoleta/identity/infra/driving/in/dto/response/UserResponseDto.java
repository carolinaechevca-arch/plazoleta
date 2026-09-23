package com.plazoleta.identity.infra.driving.in.dto.response;

import com.plazoleta.identity.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    Long id;
    String dni;
    String name;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate birthDate;
    Role role;
}

package com.plazoleta.identity.infra.driving.in.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static com.plazoleta.identity.infra.driving.in.util.UserConstantsAdapter.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotBlank(message = DNI_REQUIRED)
    @Pattern(regexp = REGEX_NUMERIC, message = DNI_NUMERIC)
    private String dni;

    @NotBlank(message = FIRST_NAME_REQUIRED)
    private String name;

    @NotBlank(message = LAST_NAME_REQUIRED)
    private String lastName;

    @NotBlank(message = EMAIL_REQUIRED)
    @Email(message = EMAIL_INVALID)
    private String email;

    @NotBlank(message = PASSWORD_REQUIRED)
    private String password;

    @NotBlank(message = PHONE_REQUIRED)
    @Pattern(regexp = REGEX_PHONE, message = PHONE_FORMAT)
    private String phoneNumber;

    @Past(message = DATE_PAST)
    LocalDate birthDate;
}

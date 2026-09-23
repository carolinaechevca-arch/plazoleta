package com.plazoleta.identity.domain.model;

import com.plazoleta.identity.domain.enums.Role;
import com.plazoleta.identity.domain.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor()
@NoArgsConstructor
public class User {

    Long id;
    String dni;
    String name;
    String lastName;
    String email;
    String password;
    String phoneNumber;
    LocalDate birthDate;
    Role role;

    public static class UserBuilder {
        public User build() {
            validateDni(this.dni);
            validateEmail(this.email);
            validatePhoneNumber(this.phoneNumber);

            return new User(
                    this.id, this.dni, this.name, this.lastName,
                    this.email, this.password, this.phoneNumber, this.birthDate, this.role
            );
        }

        private void validateDni(String dni) {
            if (dni == null || dni.isBlank()) throw new BadRequestException("DNI is required");
            if (!dni.matches("\\d+")) throw new BadRequestException("DNI must be numeric");
        }

        private void validateEmail(String email) {
            if (email == null || email.isBlank()) throw new BadRequestException("Email is required");
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) throw new BadRequestException("Invalid email format");
        }

        private void validatePhoneNumber(String phone) {
            if (phone == null || phone.isBlank()) throw new BadRequestException("Phone number is required");
            if (!phone.matches("\\+\\d{1,13}")) throw new BadRequestException("Phone number must start with '+' and include country code (max 16 characters)");
        }
    }
}
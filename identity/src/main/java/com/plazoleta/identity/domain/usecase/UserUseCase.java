package com.plazoleta.identity.domain.usecase;

import com.plazoleta.identity.domain.enums.Role;
import com.plazoleta.identity.domain.exceptions.BadRequestException;
import com.plazoleta.identity.domain.exceptions.NotFoundException;
import com.plazoleta.identity.domain.model.User;
import com.plazoleta.identity.domain.port.in.IUserServicePort;
import com.plazoleta.identity.domain.port.out.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    @Override
    public User createUser(User user, Role role) {
        validateUserIsAdult(user.getBirthDate());
        validateEmail(user.getEmail());
        validateDni(user.getDni());
        User userWithRole = user.toBuilder()
                .role(role)
                .build();

        return userPersistencePort.save(userWithRole);
    }

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    private void validateUserIsAdult(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        LocalDate adultDate = today.minusYears(18);
        if (birthDate.isAfter(adultDate)) {
            throw new BadRequestException("User must be at least 18 years old");
        }
    }

    private void validateEmail(String email) {
        if(userPersistencePort.existsUserByEmail(email)){
            throw new BadRequestException("User must be at least 18 years old");
        }
    }

    private void validateDni(String dni) {
        if(userPersistencePort.existsUserByDni(dni)){
            throw new BadRequestException("User must be at least 18 years old");
        }

    }

}

package com.jospin.user_service.user.validations;

import com.jospin.user_service.user.entity.User;
import com.jospin.user_service.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private final UserRepository userRepository;

    public Validator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateUserExists(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ValidationException(
                                "User not found with id " + id,
                                ValidationErrorType.NOT_FOUND
                        )
                );
    }

    public void validateEmailNotExists(String email) {
        boolean exists = userRepository.findAll()
                .stream()
                .anyMatch(u -> u.getEmail().equals(email));

        if (exists) {
            throw new ValidationException(
                    "Email already exists",
                    ValidationErrorType.ALREADY_EXISTS
            );
        }
    }

    public void validateEmailForUpdate(String email, Long id){

    if(userRepository.existsByEmailAndIdNot(email,id)){
        throw new ValidationException(
                "Email already exists",
                ValidationErrorType.ALREADY_EXISTS
        );
    }
}
}

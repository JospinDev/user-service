package com.jospin.user_service.user.validations;

public class ValidationException extends RuntimeException {

    private final ValidationErrorType type;

    public ValidationException(String message, ValidationErrorType type) {
        super(message);
        this.type = type;
    }

    public ValidationErrorType getType() {
        return type;
    }
}

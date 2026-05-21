package com.jospin.user_service.user.validations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponseValidation> handleValidation(ValidationException ex) {

        ErrorResponseValidation response = ErrorResponseValidation.builder()
                .message(ex.getMessage())
                .type(ex.getType())
                .timestamp(LocalDateTime.now())
                .build();

        HttpStatus status = switch (ex.getType()) {
            case NOT_FOUND -> HttpStatus.NOT_FOUND;
            case ALREADY_EXISTS -> HttpStatus.CONFLICT;
            case INVALID_REQUEST -> HttpStatus.BAD_REQUEST;
            default -> HttpStatus.BAD_REQUEST;
        };

        return new ResponseEntity<>(response, status);
    }
}

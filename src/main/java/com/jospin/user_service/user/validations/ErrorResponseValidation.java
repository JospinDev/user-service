package com.jospin.user_service.user.validations;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseValidation {

    private String message;
    private ValidationErrorType type;
    private LocalDateTime timestamp;
}
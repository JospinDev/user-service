package com.jospin.user_service.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    @NotBlank(message = "Le Nom est obligatoire")
    @Size(min = 2, max = 80, message = "Le Nom doit contenir entre 2 et 80 caractères")
    private String fullName;

    @NotBlank(message = "L'email est obligatoire")
    private String email;
}
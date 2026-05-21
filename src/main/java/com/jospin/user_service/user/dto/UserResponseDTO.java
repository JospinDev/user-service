package com.jospin.user_service.user.dto;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
}

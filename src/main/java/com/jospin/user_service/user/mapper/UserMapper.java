package com.jospin.user_service.user.mapper;

import com.jospin.user_service.user.dto.UserDTO;
import com.jospin.user_service.user.dto.UserResponseDTO;
import com.jospin.user_service.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDTO dto){
        return User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .build();
    }

    public UserResponseDTO toResponseDTO(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();
    }

    public void updateEntityFromDTO(UserDTO dto, User user) {
        user.setFullName(dto.getFullName());
        user.setEmail((dto.getEmail()));
    }

}

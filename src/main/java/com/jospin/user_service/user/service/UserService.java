package com.jospin.user_service.user.service;

import java.util.List;

import com.jospin.user_service.user.dto.UserDTO;
import com.jospin.user_service.user.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserDTO dto);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UserDTO dto);
    void deleteUser(Long id);

}

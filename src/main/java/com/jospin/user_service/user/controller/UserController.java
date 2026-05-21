package com.jospin.user_service.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jospin.user_service.user.service.UserService;

import com.jospin.user_service.user.common.ApiResponse;
import com.jospin.user_service.user.dto.UserResponseDTO;
import com.jospin.user_service.user.dto.UserDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(
            @Valid @RequestBody UserDTO requestDTO) {

        UserResponseDTO user = userService.createUser(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Utilisateur créé avec succès", user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(
            @PathVariable Long id) {

        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {

        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success(
            "Tous les Utilisateurs",
            users
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("Utilisateur supprimé avec succès")
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUser(@PathVariable Long id,
            @Valid @RequestBody UserDTO dto){

                UserResponseDTO user = userService.updateUser(id, dto);

                return ResponseEntity.ok(ApiResponse.success("Utilisateur modifier avec succès", user));
    }


}

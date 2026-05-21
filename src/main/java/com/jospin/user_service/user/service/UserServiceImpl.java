package com.jospin.user_service.user.service;

import com.jospin.user_service.user.dto.UserDTO;
import com.jospin.user_service.user.dto.UserResponseDTO;
import com.jospin.user_service.user.entity.User;
import com.jospin.user_service.user.mapper.UserMapper;

import com.jospin.user_service.user.validations.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jospin.user_service.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private final Validator validator;
    private final UserRepository repo;
    private final UserMapper userMapper;

    public UserResponseDTO createUser(UserDTO dto){

        validator.validateEmailNotExists(dto.getEmail());
        
        User user = userMapper.toEntity(dto);
        User savedUser = repo.save(user);

        return userMapper.toResponseDTO(savedUser);
    }

    public UserResponseDTO getUserById(Long id){

        validator.validateUserExists(id);

        User user = repo.findById(id).get();

        return userMapper.toResponseDTO(user);

    }

    public UserResponseDTO updateUser(Long id, UserDTO dto){
        User user = validator.validateUserExists(id);
        validator.validateEmailForUpdate(dto.getEmail(), id);

        userMapper.updateEntityFromDTO(dto, user);

        User updatedUser = repo.save(user);

        return userMapper.toResponseDTO(updatedUser);
    }

    public List<UserResponseDTO> getAllUsers(){

        return repo.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id){
        User user = validator.validateUserExists(id);


        repo.delete(user);
    }


}

package com.example.messagebroker.service;

import com.example.messagebroker.dto.CreateUserDto;
import com.example.messagebroker.dto.UserDto;
import com.example.messagebroker.model.User;

import java.util.List;

public interface UserService {
    long save(CreateUserDto user);
    List<User> getUsers();
    List<UserDto> getAllUsers();

    UserDto getById(Long id);
}

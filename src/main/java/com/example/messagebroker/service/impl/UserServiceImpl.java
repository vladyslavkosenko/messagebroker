package com.example.messagebroker.service.impl;

import com.example.messagebroker.dto.CreateUserDto;
import com.example.messagebroker.dto.UserDto;
import com.example.messagebroker.exception.UserNotFoundException;
import com.example.messagebroker.model.User;
import com.example.messagebroker.repository.UserRepository;
import com.example.messagebroker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public long save(CreateUserDto user) {
        return userRepository.save(modelMapper.map(user, User.class)).getId();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDto> getAllUsers() {
        ArrayList<User> arrayList = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(arrayList::add);
        return arrayList
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public UserDto getById(Long id) {
        return userRepository.findById(id).map(user -> modelMapper.map(user, UserDto.class))
                .orElseThrow(() -> new UserNotFoundException("User with this id not found!"));
    }
}
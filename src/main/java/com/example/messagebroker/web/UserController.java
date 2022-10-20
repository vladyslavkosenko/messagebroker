package com.example.messagebroker.web;

import com.example.messagebroker.dto.CreateUserDto;
import com.example.messagebroker.dto.UserDto;
import com.example.messagebroker.model.User;
import com.example.messagebroker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveUser(@Validated @RequestBody CreateUserDto user){
        return  userService.save(user);
    }
    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDto getUserByUserId(@PathVariable Long id) {
        return userService.getById(id);
    }
}



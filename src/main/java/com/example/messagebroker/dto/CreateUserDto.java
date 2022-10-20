package com.example.messagebroker.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CreateUserDto {

    private String firstName;
    private String lastName;

    @Min(value = 0, message = "age cannot be less than 0")
    @Max(value = 100, message = "Max age is 100")
    private int age;

}
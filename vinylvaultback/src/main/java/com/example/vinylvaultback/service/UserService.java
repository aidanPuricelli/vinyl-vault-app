package com.example.vinylvaultback.service;

import com.example.vinylvaultback.dto.LoginDto;
import com.example.vinylvaultback.dto.UserDto;
import com.example.vinylvaultback.model.User;
import com.example.vinylvaultback.response.LoginResponse;


import java.util.List;

public interface UserService {

    String save(UserDto userDto);

    Long loginEmployee(LoginDto loginDto);

}

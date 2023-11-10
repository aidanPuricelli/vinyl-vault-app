package com.example.vinylvaultback.service.impl;

import com.example.vinylvaultback.dto.LoginDto;
import com.example.vinylvaultback.dto.UserDto;
import com.example.vinylvaultback.manager.SessionManager;
import com.example.vinylvaultback.model.User;
import com.example.vinylvaultback.repo.UserRepo;
import com.example.vinylvaultback.response.LoginResponse;
import com.example.vinylvaultback.service.UserService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;
    private SessionManager sessionManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String save(UserDto userDto) {

        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                this.passwordEncoder.encode(userDto.getPassword()),
                userDto.getEmail(),
                userDto.getProfilePicture()
        );

        userRepo.save(user);

        return user.getUsername();
    }

    @Override
    public Long loginEmployee(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepo.findUserByEmail(loginDto.getEmail());

        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), user1.getPassword());
                if (user.isPresent()) {
                    return user1.getId();
                } else {
                    return 1000L; // LOGIN FAILED
                }
            } else {

                return 2000L; // PASSWORD DOESN'T MATCH
            }

        } else {
            return 3000L; // USER NOT FOUND
        }
    }

}

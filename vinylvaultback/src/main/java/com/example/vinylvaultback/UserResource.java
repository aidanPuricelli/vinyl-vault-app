package com.example.vinylvaultback;

import com.example.vinylvaultback.dto.LoginDto;
import com.example.vinylvaultback.dto.UserDto;
import com.example.vinylvaultback.model.User;
import com.example.vinylvaultback.repo.UserRepo;
import com.example.vinylvaultback.response.LoginResponse;
import com.example.vinylvaultback.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserRepo userRepo;

    public UserResource(UserService userService, UserRepo userRepo) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto) {
        // Save the user details in the database
        String id = userService.save(userDto);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        Long loginResponse = userService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/get-user-details")
    public ResponseEntity<String> getUsername(@RequestParam("id") Long id) {
        // Assuming you have a UserRepo
        User user = userRepo.findUserById(id);

        String username = user.getUsername();
        String profilePic = user.getProfilePicture();

        String jsonResponse = "{\"username\":\"" + username + "\", \"profilePic\":\"" + profilePic + "\"}";

        return ResponseEntity.ok(jsonResponse);
    }

    @PostMapping("/change-profile-picture")
    public ResponseEntity<String> changeProfilePicture(@RequestParam("id") Long id, @RequestParam("url") String picUrl) {
        User user = userRepo.findUserById(id);

        String jsonResponse = "{\"profilePic\":\"" + "profilePic" + "\"}";

        user.setProfilePicture(picUrl);

        userRepo.save(user);

        return ResponseEntity.ok(jsonResponse);
    }

}

package com.devmountain.noteApp.controllers;

// CONTROLLERS - define REST API endpoints and creating
// the paths that can deliver up the information to the client


import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // First we need to Autowired in our Dependencies, which are
        // the UserService because Controllers interact with ServiceLayers
        // and the PasswordEncoder so that we can has incoming passwords
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // method that will handle POST requests to be able to register a User
    // @RequestBody annotation so that the JSON body object on the request gets mapped to our DTO and becomes usable
    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto ) {
        String passHash = passwordEncoder.encode( userDto.getPassword() ); // encode pw from in from user
        userDto.setPassword( passHash ); // set the hashed pw
        return userService.addUser( userDto ); // run addUser method from userService with the user object
    }

    // POST request to log in a user
    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto) {
        return userService.userLogin( userDto );
    }

}

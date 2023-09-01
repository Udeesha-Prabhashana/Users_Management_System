package com.udeesha.userhandlesystembackend.controller;

import com.udeesha.userhandlesystembackend.model.User;
import com.udeesha.userhandlesystembackend.repository.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepositary userRepositary;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepositary.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepositary.findAll();
    }

}

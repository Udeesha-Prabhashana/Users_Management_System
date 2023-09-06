package com.udeesha.userhandlesystembackend.controller;

import com.udeesha.userhandlesystembackend.exception.UserNotFoundException;
import com.udeesha.userhandlesystembackend.model.User;
import com.udeesha.userhandlesystembackend.repository.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")  //use to connect frontend application adn backend application ,by give react local host port in frontend
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

    @GetMapping("user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepositary.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepositary.findById(id)
                .map(user ->{
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepositary.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));

    }

    @DeleteMapping("user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepositary.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepositary.deleteById(id);
        return "User with id "+id+ "has been deleted success";
    }

}

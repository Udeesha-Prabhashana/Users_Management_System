package com.udeesha.userhandlesystembackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found the user with id " + id);       //give error message if not found user
    }
}

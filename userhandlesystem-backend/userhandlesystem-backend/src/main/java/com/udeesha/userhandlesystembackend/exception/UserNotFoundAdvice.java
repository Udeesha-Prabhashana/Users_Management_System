package com.udeesha.userhandlesystembackend.exception;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class UserNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler
    @ResponseStatus
    public Map<String,String> exceptionHandler(UserNotFoundException exception){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }
}

package com.infoLAND.RestfulAPI.API.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationHandler(MethodArgumentNotValidException exception) {
        HashMap<String, Object> resObj = new HashMap<>();
        List<String> errorDetails = new ArrayList<>();

//        Add all errors to the list
        if (exception.getErrorCount() > 0) {
            for (ObjectError error : exception.getBindingResult().getAllErrors()) {
                errorDetails.add(error.getDefaultMessage());
            }
        }

        resObj.put("status", HttpStatus.BAD_REQUEST.value());
        resObj.put("message", "Validation is failed!");
        if (!errorDetails.isEmpty()) resObj.put("Errors", errorDetails);

        return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
    }
}

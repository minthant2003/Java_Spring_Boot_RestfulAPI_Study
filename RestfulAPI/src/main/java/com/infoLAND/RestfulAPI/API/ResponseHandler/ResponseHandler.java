package com.infoLAND.RestfulAPI.API.ResponseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResponseHandler {
    public ResponseEntity<Object> generateCustomResponse(String msg, HttpStatus status, Optional<Object> data) {
        Map<String, Object> map = new HashMap<>();
        if (data.isPresent()) map.put("data", data);
        map.put("message", msg);
        map.put("status", status.value());

        return new ResponseEntity<>(map, status);
    }
}

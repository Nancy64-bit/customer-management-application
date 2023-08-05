package com.sunbasedata.customermanagement.customermanagementapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbasedata.customermanagement.customermanagementapp.model.AuthRequest;

@RestController
public class AuthController {

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@RequestBody AuthRequest request) {
        if ("test@sunbasedata.com".equals(request.getLoginId()) && "Test@123".equals(request.getPassword())) {
            Map<String, String> response = new HashMap<>();
            response.put("token", "your_generated_token");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

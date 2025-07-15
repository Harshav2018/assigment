package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest) {
        User user = userService.authenticateUser(loginRequest.username, loginRequest.password);
        Map<String, String> response = new HashMap<>();
        
        if (user != null) {
            response.put("token", "fake_jwt_token_" + user.id);
            response.put("role", user.role);
        } else {
            response.put("error", "Invalid credentials");
        }
        
        return response;
    }
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }
}

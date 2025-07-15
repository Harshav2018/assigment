package com.example.ecommerce.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    public String generateToken(String username) {
        return "fake_token_" + username;
    }
    
    public boolean validateToken(String token) {
        return token.startsWith("fake_token_");
    }
}

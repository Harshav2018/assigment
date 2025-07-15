package com.example.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public String username;
    public String password;
    public String role;
    public String email;
    
    public User() {}
    
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
    
    public boolean isAdmin() {
        return "admin".equals(role);
    }
}

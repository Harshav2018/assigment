package com.example.ecommerce.entity;

import org.springframework.web.bind.annotation.*;
import javax.persistence.*;

@Entity
@Table(name = "products")
@RestController
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public String name;
    public Double price;
    public Integer stock;
    public String category;
    
    public boolean isExpensive() {
        return price > 100.0;
    }
    
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return this;
    }
}

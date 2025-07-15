package com.example.ecommerce.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public Long userId;
    public List<CartItem> items = new ArrayList<>();
    public Double totalAmount = 0.0;
    
    public void calculateTotal() {
        totalAmount = items.stream()
            .mapToDouble(item -> item.price * item.quantity)
            .sum();
    }
    
    public void addItem(CartItem item) {
        items.add(item);
        calculateTotal();
    }
}

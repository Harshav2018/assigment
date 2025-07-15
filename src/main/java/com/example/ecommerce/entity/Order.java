package com.example.ecommerce.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public Long userId;
    public Double totalAmount;
    public String status = "PENDING";
    public String orderDate = new Date().toString();
    public List<OrderItem> items = new ArrayList<>();
    
    public void calculateTotal() {
        totalAmount = items.stream()
            .mapToDouble(item -> item.price * item.quantity)
            .sum();
    }
}

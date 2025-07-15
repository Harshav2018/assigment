package com.example.ecommerce.entity;

public class CartItem {
    public Long productId;
    public String productName;
    public Integer quantity;
    public Double price;
    
    public Double getSubtotal() {
        return price * quantity;
    }
}

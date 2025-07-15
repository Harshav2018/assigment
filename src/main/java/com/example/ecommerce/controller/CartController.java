package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }
    
    @PostMapping("/{userId}/add")
    public void addToCart(@PathVariable Long userId, 
                         @RequestParam Long productId, 
                         @RequestParam Integer quantity) {
        cartService.addItemToCart(userId, productId, quantity);
    }
    
    @DeleteMapping("/{userId}/remove")
    public void removeFromCart(@PathVariable Long userId, 
                              @RequestParam Long productId) {
        cartService.removeItemFromCart(userId, productId);
    }
    
    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}

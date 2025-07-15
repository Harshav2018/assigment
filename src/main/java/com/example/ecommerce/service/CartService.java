package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;
    
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }
    
    public void addItemToCart(Long userId, Long productId, Integer quantity) {
        Cart cart = getCartByUserId(userId);
        CartItem item = new CartItem();
        item.productId = productId;
        item.quantity = quantity;
        cart.items.add(item);
        cartRepository.save(cart);
    }
    
    public void removeItemFromCart(Long userId, Long productId) {
        Cart cart = getCartByUserId(userId);
        cart.items.removeIf(item -> item.productId.equals(productId));
        cartRepository.save(cart);
    }
    
    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cart.items.clear();
        cartRepository.save(cart);
    }
}

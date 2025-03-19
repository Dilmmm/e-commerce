package com.ecommerce.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.model.Cart;
import com.ecommerce.backend.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> findAll() {
        return (List<Cart>) cartRepository.findAll();
    }

    public Optional<Cart> findById(Integer id) {
        return cartRepository.findById(id);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

}

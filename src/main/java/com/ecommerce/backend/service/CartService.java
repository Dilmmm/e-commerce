package com.ecommerce.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.model.Cart;
import com.ecommerce.backend.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findById(Integer id) {
        return cartRepository.findById(id);
    }

    public <S extends Cart> S save(S entity) {
        return cartRepository.save(entity);
    }

}

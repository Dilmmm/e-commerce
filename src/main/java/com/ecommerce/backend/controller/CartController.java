package com.ecommerce.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.model.Cart;
import com.ecommerce.backend.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Tous les paniers
    @GetMapping("/all")
    public Iterable<Cart> getAllCart() {
        return cartService.findAll();
    }

    // Panier par id
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Integer id) {
        return cartService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ajouter un panier
    @PostMapping("/add")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }
}

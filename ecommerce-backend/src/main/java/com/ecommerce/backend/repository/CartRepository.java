package com.ecommerce.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.backend.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

}

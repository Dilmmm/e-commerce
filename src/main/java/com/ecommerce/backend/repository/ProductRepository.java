package com.ecommerce.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.backend.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}

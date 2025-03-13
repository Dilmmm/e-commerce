package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public <S extends Category> S save(S entity) {
        return categoryRepository.save(entity);
    }

}

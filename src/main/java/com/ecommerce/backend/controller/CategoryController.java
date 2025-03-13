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

import com.ecommerce.backend.model.Category;
import com.ecommerce.backend.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Tous les produits
    @GetMapping("/all")
    public Iterable<Category> getAllCategories() {
        return categoryService.findAll();
    }

    // Produit par id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ajouter un produit
    @PostMapping("/add")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
}

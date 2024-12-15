package com.example.warehouse.controllers;

import com.example.warehouse.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.warehouse.repositories.CategoryRepository;


@RestController


@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}

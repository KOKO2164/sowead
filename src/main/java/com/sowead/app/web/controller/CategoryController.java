package com.sowead.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowead.app.domain.Category;
import com.sowead.app.domain.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/save")
    public Category save(Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int categoryId) {
        return categoryService.delete(categoryId);
    }
}

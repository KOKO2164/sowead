package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.Category;

public interface CategoryRepository {
    List<Category> getAll();
    Optional<Category> getCategory(int categoryId);
    Category save(Category category);
    void delete(int categoryId);
}

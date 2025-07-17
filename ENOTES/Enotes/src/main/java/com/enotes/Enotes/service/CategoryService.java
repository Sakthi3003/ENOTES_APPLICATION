package com.enotes.Enotes.service;

import com.enotes.Enotes.entity.Category;

import java.util.List;

public interface CategoryService {
    Boolean saveCategory(Category category);
    List<Category> getAllCategories();
}

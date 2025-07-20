package com.enotes.Enotes.service;

import com.enotes.Enotes.dto.AddCategoryDTO;
import com.enotes.Enotes.dto.CategoryDto;
import com.enotes.Enotes.dto.UpdateCategoryDto;

import java.util.List;

public interface CategoryService {
    Boolean saveCategory(AddCategoryDTO category);
    List<CategoryDto> getAllCategories();
    List<CategoryDto> getAllActiveCategories();
    CategoryDto getCategoryDetailsById(String categoryId);
    Boolean deleteCategoryById(String categoryId);
    CategoryDto updateCategory(UpdateCategoryDto categoryDto);
}

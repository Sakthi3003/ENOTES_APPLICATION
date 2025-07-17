package com.enotes.Enotes.service.impl;

import com.enotes.Enotes.entity.Category;
import com.enotes.Enotes.repository.CategoryRepository;
import com.enotes.Enotes.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Boolean saveCategory(Category category) {
        category.setIsDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedDate(LocalDate.from(LocalDateTime.now()));
        category.setUpdatedBy(1);
        category.setUpdatedDate(LocalDate.from(LocalDateTime.now()));
        Category category1 = categoryRepository.save(category);
        if(ObjectUtils.isEmpty(category1)) {
            return false;
        }
        return true;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}

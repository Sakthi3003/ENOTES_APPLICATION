package com.enotes.Enotes.service.impl;

import com.enotes.Enotes.dto.AddCategoryDTO;
import com.enotes.Enotes.dto.CategoryDto;
import com.enotes.Enotes.entity.Category;
import com.enotes.Enotes.repository.CategoryRepository;
import com.enotes.Enotes.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public Boolean saveCategory(AddCategoryDTO categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName().trim());
        category.setDescription(categoryDto.getDescription().trim());
        category.setCreatedBy(1);
        Category savedCategory = categoryRepository.save(category);
        if(ObjectUtils.isEmpty(savedCategory)) {
            return false;
        }
        return true;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDto> categoryDtos = categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
        return categoryDtos;
    }

    @Override
    public List<CategoryDto> getAllActiveCategories() {
        List<Category> categories = categoryRepository.findByIsActiveTrue();

        List<CategoryDto> categoryDtos = categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
        return categoryDtos;

    }
}

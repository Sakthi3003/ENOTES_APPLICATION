package com.enotes.Enotes.service.impl;

import com.enotes.Enotes.dto.AddCategoryDTO;
import com.enotes.Enotes.dto.CategoryDto;
import com.enotes.Enotes.dto.UpdateCategoryDto;
import com.enotes.Enotes.entity.Category;
import com.enotes.Enotes.exception.CategoryNotFoundException;
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
        Category category = modelMapper.map(categoryDto, Category.class);
        if(ObjectUtils.isEmpty(category.getId())) {
            category.setCreatedBy(1);
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

    public CategoryDto updateCategory(UpdateCategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryDto.getId())
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " +categoryDto.getId() + " not found"));
        if(ObjectUtils.isEmpty(category)) {
            return null;
        }else{
            if(!category.getName().equals(categoryDto.getName())) {
                category.setName(categoryDto.getName());
            }
            category.setDescription(categoryDto.getDescription());
            return modelMapper.map(categoryRepository.save(category), CategoryDto.class);
        }
    }


    @Override
    public List<CategoryDto> getAllActiveCategories() {
        List<Category> categories = categoryRepository.findByIsActiveTrueAndIsDeletedFalse();

        List<CategoryDto> categoryDtos = categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
        return categoryDtos;

    }



    @Override
    public CategoryDto getCategoryDetailsById(String categoryId) {
        Category category = categoryRepository.findByIdAndIsDeletedFalse(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " +categoryId + " not found"));
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        categoryDto.setCreatedAt(category.getCreatedAt());
        categoryDto.setUpdatedAt(category.getUpdatedAt());
        categoryDto.setUpdatedBy(category.getUpdatedBy());
        return categoryDto;
    }

    @Override
    public Boolean deleteCategoryById(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " +categoryId + " not found"));
        if(category.getIsDeleted() == true){
            return false;
        }
        category.setIsDeleted(true);
        categoryRepository.save(category);
        return true;
    }
}

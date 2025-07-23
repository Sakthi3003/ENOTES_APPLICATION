package com.enotes.Enotes.controller;

import com.enotes.Enotes.dto.AddCategoryDTO;
import com.enotes.Enotes.dto.CategoryDto;
import com.enotes.Enotes.dto.UpdateCategoryDto;
import com.enotes.Enotes.entity.Category;
import com.enotes.Enotes.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();

        if(CollectionUtils.isEmpty(categories)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody AddCategoryDTO category) {
        Boolean savedCategory = categoryService.saveCategory(category);

        if(savedCategory) {
            return new ResponseEntity<>("Category saved successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Category save failed. Try again later", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/active")
    public ResponseEntity<List<CategoryDto>> getActiveCategories() {
        List<CategoryDto>  categoryDtos =  categoryService.getAllActiveCategories();
        if(CollectionUtils.isEmpty(categoryDtos)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable String id) {
        CategoryDto categoryDto = categoryService.getCategoryDetailsById(id);
        if(ObjectUtils.isEmpty(categoryDto)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateCategory(@Valid @RequestBody UpdateCategoryDto category) {
        CategoryDto updatedCategoryDto = categoryService.updateCategory(category);
        if(ObjectUtils.isEmpty(updatedCategoryDto)) {
            return new ResponseEntity<>("Category with id not found " + category.getId(),HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable String id) {
        Boolean  deletedCategory = categoryService.deleteCategoryById(id);
        if(deletedCategory) {
            return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

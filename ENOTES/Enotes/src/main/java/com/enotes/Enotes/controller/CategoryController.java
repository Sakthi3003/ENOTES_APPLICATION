package com.enotes.Enotes.controller;

import com.enotes.Enotes.dto.AddCategoryDTO;
import com.enotes.Enotes.dto.CategoryDto;
import com.enotes.Enotes.entity.Category;
import com.enotes.Enotes.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
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
}

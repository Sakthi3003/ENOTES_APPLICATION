package com.enotes.Enotes.util;

import com.enotes.Enotes.dto.AddCategoryDTO;
import com.enotes.Enotes.dto.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CategoryValidation {

    public void categoryValidation(AddCategoryDTO category) {
        Map<String, Object> errors =  new LinkedHashMap<>();
        if(ObjectUtils.isEmpty(category)) {
           throw new IllegalArgumentException("Category must not be null or empty");
        }else{
            // name field validation
            if(ObjectUtils.isEmpty(category.getName())) {
                errors.put("name","Category name must not be empty");
            }else{
                if(category.getName().length()<10) {
                    errors.put("name","Category name must not be less than 10 characters");
                }
                if(category.getName().length()>100) {
                    errors.put("name","Category name must not be greater than 100 characters");
                }
            }

            // Description

            if(ObjectUtils.isEmpty(category.getDescription())) {
                errors.put("description","Category description must not be empty");
            }
        }

        if(!errors.isEmpty()) {
            throw new RuntimeException(errors.toString());
        }
    }
}

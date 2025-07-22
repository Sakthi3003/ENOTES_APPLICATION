package com.enotes.Enotes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryDto {

    @NotBlank(message = "Category Id required to update category")
    @NotEmpty
    private String id;

    @NotBlank(message = "Category name must not be blank")
    @NotNull(message = "Category name must not be null")
    private String name;

    private String description;
}

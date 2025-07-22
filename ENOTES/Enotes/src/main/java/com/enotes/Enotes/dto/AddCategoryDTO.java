package com.enotes.Enotes.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AddCategoryDTO {
    @NotBlank(message = "Category name must not be blank")
    @Min(value = 100)
    @Max(value = 100)
    private String name;

    private String description;
}

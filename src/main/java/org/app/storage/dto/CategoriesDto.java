package org.app.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDto {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}


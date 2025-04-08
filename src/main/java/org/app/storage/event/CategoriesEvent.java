package org.app.storage.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesEvent {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}


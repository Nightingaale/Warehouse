package org.app.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.entity.CategoriesEntity;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {
    private Long productId;
    private CategoriesEntity categoryId;
    private String productName;
    private String productDescription;
    private Date addedAt;
    private Date updatedAt;
}
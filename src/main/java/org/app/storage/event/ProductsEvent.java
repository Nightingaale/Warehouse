package org.app.storage.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.models.Categories;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsEvent {
    private Long productId;
    private Categories categoryId;
    private String productName;
    private String productDescription;
    private Date addedAt;
    private Date updatedAt;
}
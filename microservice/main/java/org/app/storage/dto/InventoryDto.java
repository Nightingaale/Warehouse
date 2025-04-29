package org.app.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.entity.ProductsEntity;
import org.app.storage.entity.WarehousesEntity;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    private Long inventoryId;
    private ProductsEntity productId;
    private WarehousesEntity warehouseId;
    private Long quantity;
    private Date lastUpdated;
}


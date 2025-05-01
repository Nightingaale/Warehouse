package org.app.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.entity.ProductsEntity;
import org.app.storage.entity.SuppliersEntity;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehousesDto {
    private Long warehouseId;
    private SuppliersEntity supplierId;
    private ProductsEntity productId;
    private String warehouseName;
    private String storageLocation;
    private Date addedAt;
}


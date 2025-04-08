package org.app.storage.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.models.Products;
import org.app.storage.models.Suppliers;
import org.app.storage.models.Warehouses;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehousesEvent {
    private Long warehouseId;
    private Suppliers supplierId;
    private Products productId;
    private String warehouseName;
    private String storageLocation;
    private Date addedAt;
}


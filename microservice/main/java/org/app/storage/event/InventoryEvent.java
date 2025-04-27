package org.app.storage.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.models.Products;
import org.app.storage.models.Warehouses;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEvent {
    private Long inventoryId;
    private Products productId;
    private Warehouses warehouseId;
    private Long quantity;
    private Date lastUpdated;
}


package org.app.storage.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private ProductsEntity productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId")
    private WarehousesEntity warehouseId;

    private Long quantity;

    @CreationTimestamp
    private Date lastUpdated;
}

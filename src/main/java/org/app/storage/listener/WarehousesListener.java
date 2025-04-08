package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.WarehousesEvent;
import org.app.storage.models.Warehouses;
import org.app.storage.repo.WarehousesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehousesListener {

    private final WarehousesRepository warehousesRepository;

    public static WarehousesEvent ToDto(Warehouses warehouse) {
        return new WarehousesEvent(
                warehouse.getWarehouseId(),
                warehouse.getSupplierId(),
                warehouse.getProductId(),
                warehouse.getWarehouseName(),
                warehouse.getStorageLocation(),
                warehouse.getAddedAt()
        );
    }

    public static Warehouses ToEntity(WarehousesEvent warehousesEvent) {
        Warehouses warehouses = new Warehouses();
        warehouses.setWarehouseId(warehousesEvent.getWarehouseId());
        warehouses.setSupplierId(warehousesEvent.getSupplierId());
        warehouses.setProductId(warehousesEvent.getProductId());
        warehouses.setWarehouseName(warehousesEvent.getWarehouseName());
        warehouses.setStorageLocation(warehousesEvent.getStorageLocation());
        warehouses.setAddedAt(warehousesEvent.getAddedAt());
        return warehouses;
    }


    public Optional<Warehouses> getWarehouseInfo(Long id) {
        Optional<Warehouses> warehouseInfo = warehousesRepository.findById(id);
        if (warehouseInfo.isEmpty()) {
            return Optional.empty();
        }
        Warehouses warehouse = warehouseInfo.get();
        Warehouses DTO = convertToWarehouseDto(warehouse);
        return Optional.of(DTO);
    }

    public static Warehouses convertToWarehouseDto(Warehouses warehouse) {
        return new Warehouses(
                warehouse.getWarehouseId(),
                warehouse.getSupplierId(),
                warehouse.getProductId(),
                warehouse.getStorageLocation(),
                warehouse.getWarehouseName(),
                warehouse.getAddedAt()
        );
    }
}

package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.WarehousesDto;
import org.app.storage.entity.WarehousesEntity;
import org.app.storage.repo.WarehousesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehousesListener {

    private final WarehousesRepository warehousesRepository;

    public static WarehousesDto ToDto(WarehousesEntity warehouse) {
        return new WarehousesDto(
                warehouse.getWarehouseId(),
                warehouse.getSupplierId(),
                warehouse.getProductId(),
                warehouse.getWarehouseName(),
                warehouse.getStorageLocation(),
                warehouse.getAddedAt()
        );
    }

    public static WarehousesEntity ToEntity(WarehousesDto warehousesEvent) {
        WarehousesEntity warehouses = new WarehousesEntity();
        warehouses.setWarehouseId(warehousesEvent.getWarehouseId());
        warehouses.setSupplierId(warehousesEvent.getSupplierId());
        warehouses.setProductId(warehousesEvent.getProductId());
        warehouses.setWarehouseName(warehousesEvent.getWarehouseName());
        warehouses.setStorageLocation(warehousesEvent.getStorageLocation());
        warehouses.setAddedAt(warehousesEvent.getAddedAt());
        return warehouses;
    }


    public Optional<WarehousesEntity> getWarehouseInfo(Long id) {
        Optional<WarehousesEntity> warehouseInfo = warehousesRepository.findById(id);
        if (warehouseInfo.isEmpty()) {
            return Optional.empty();
        }
        WarehousesEntity warehouse = warehouseInfo.get();
        WarehousesEntity DTO = convertToWarehouseDto(warehouse);
        return Optional.of(DTO);
    }

    public static WarehousesEntity convertToWarehouseDto(WarehousesEntity warehouse) {
        return new WarehousesEntity(
                warehouse.getWarehouseId(),
                warehouse.getSupplierId(),
                warehouse.getProductId(),
                warehouse.getStorageLocation(),
                warehouse.getWarehouseName(),
                warehouse.getAddedAt()
        );
    }
}

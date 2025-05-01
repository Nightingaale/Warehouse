package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.InventoryDto;
import org.app.storage.entity.InventoryEntity;
import org.app.storage.repo.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryListener {

    private final InventoryRepository inventoryRepository;

    public static InventoryDto ToDto(InventoryEntity inventory) {
        return new InventoryDto(
                inventory.getInventoryId(),
                inventory.getProductId(),
                inventory.getWarehouseId(),
                inventory.getQuantity(),
                inventory.getLastUpdated()
        );
    }

    public static InventoryEntity ToEntity(InventoryDto event) {
        InventoryEntity inventory = new InventoryEntity();
        inventory.setInventoryId(event.getInventoryId());
        inventory.setProductId(event.getProductId());
        inventory.setWarehouseId(event.getWarehouseId());
        inventory.setQuantity(event.getQuantity());
        inventory.setLastUpdated(event.getLastUpdated());
        return inventory;
    }

    public Optional<InventoryEntity> getFullInventoryInfo(Long id) {
        Optional<InventoryEntity> inventoryOptional = inventoryRepository.findById(id);

        if (inventoryOptional.isEmpty()) {
            return Optional.empty();
        }
        InventoryEntity inventory = inventoryOptional.get();
        InventoryEntity DTO = convertToDto(inventory);
        return Optional.of(DTO);
    }

    public static InventoryEntity convertToDto(InventoryEntity inventory) {
        return new InventoryEntity(
                inventory.getInventoryId(),
                inventory.getProductId(),
                inventory.getWarehouseId(),
                inventory.getQuantity(),
                inventory.getLastUpdated()
        );
    }
}

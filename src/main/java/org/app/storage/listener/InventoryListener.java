package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.InventoryEvent;
import org.app.storage.models.Customers;
import org.app.storage.models.Inventory;
import org.app.storage.repo.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryListener {

    private final InventoryRepository inventoryRepository;

    public static InventoryEvent ToDto(Inventory inventory) {
        return new InventoryEvent(
                inventory.getInventoryId(),
                inventory.getProductId(),
                inventory.getWarehouseId(),
                inventory.getQuantity(),
                inventory.getLastUpdated()
        );
    }

    public static Inventory ToEntity(InventoryEvent event) {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(event.getInventoryId());
        inventory.setProductId(event.getProductId());
        inventory.setWarehouseId(event.getWarehouseId());
        inventory.setQuantity(event.getQuantity());
        inventory.setLastUpdated(event.getLastUpdated());
        return inventory;
    }

    public Optional<Inventory> getFullInventoryInfo(Long id) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);

        if (inventoryOptional.isEmpty()) {
            return Optional.empty();
        }
        Inventory inventory = inventoryOptional.get();
        Inventory DTO = convertToDto(inventory);
        return Optional.of(DTO);
    }

    public static Inventory convertToDto(Inventory inventory) {
        return new Inventory(
                inventory.getInventoryId(),
                inventory.getProductId(),
                inventory.getWarehouseId(),
                inventory.getQuantity(),
                inventory.getLastUpdated()
        );
    }
}

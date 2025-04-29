package org.app.storage.controller;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.CategoriesDto;
import org.app.storage.dto.InventoryDto;
import org.app.storage.dto.ProductsDto;
import org.app.storage.dto.WarehousesDto;
import org.app.storage.listener.CategoriesListener;
import org.app.storage.listener.InventoryListener;
import org.app.storage.listener.ProductsListener;
import org.app.storage.listener.WarehousesListener;
import org.app.storage.entity.CategoriesEntity;
import org.app.storage.entity.InventoryEntity;
import org.app.storage.entity.ProductsEntity;
import org.app.storage.entity.WarehousesEntity;
import org.app.storage.repo.CategoriesRepository;
import org.app.storage.repo.InventoryRepository;
import org.app.storage.repo.ProductRepository;
import org.app.storage.repo.WarehousesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/manager")
public class ManagerController {

    private final WarehousesRepository warehousesRepository;
    private final WarehousesListener warehousesListener;
    private final InventoryRepository inventoryRepository;
    private final InventoryListener inventoryListener;
    private final ProductRepository productRepository;
    private final CategoriesRepository categoriesRepository;

    @PostMapping("/createWarehouse")
    public ResponseEntity<?> createWarehouse(@RequestBody WarehousesDto warehousesEvent) {
        WarehousesEntity warehouses = WarehousesListener.ToEntity(warehousesEvent);
        WarehousesEntity savedWarehouse = warehousesRepository.save(warehouses);
        WarehousesDto responseEvent = WarehousesListener.ToDto(savedWarehouse);
        return ResponseEntity.ok("[Warehouse has been successfully created!]");
    }

    @GetMapping("/checkWarehouseInfo/{id}")
    public ResponseEntity<?> checkWarehouseInfo(@PathVariable Long id) {
        Optional<WarehousesEntity> warehouses = warehousesListener.getWarehouseInfo(id);
        WarehousesDto responseEvent = WarehousesListener.ToDto(warehouses.get());
        return ResponseEntity.ok("[Warehouse info:] " + responseEvent);
    }

    @DeleteMapping("/deleteWarehouse/{id}")
    public ResponseEntity<?> deleteWarehouse(@PathVariable Long id) {
        Optional<WarehousesEntity> warehouses = warehousesListener.getWarehouseInfo(id);
        warehousesRepository.delete(warehouses.get());
        return ResponseEntity.ok("[Warehouse has been deleted!]");
    }

    @PostMapping("/createInventory")
    public ResponseEntity<?> createInventory(@RequestBody InventoryDto inventoryEvent) {
        InventoryEntity inventory = InventoryListener.ToEntity(inventoryEvent);
        InventoryEntity savedInventory = inventoryRepository.save(inventory);
        InventoryDto responseEvent = InventoryListener.ToDto(savedInventory);
        return ResponseEntity.ok("[Inventory has been successfully created!]");
    }

    @GetMapping("/checkInventoryInfo/{id}")
    public ResponseEntity<?> checkInventoryInfo(@PathVariable Long id) {
        Optional<InventoryEntity> inventory = inventoryRepository.findById(id);
        InventoryDto responseEvent = InventoryListener.ToDto(inventory.get());
        return ResponseEntity.ok("[Inventory info:] " + responseEvent);
    }

    @DeleteMapping("/deleteInventory/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long id) {
        Optional<InventoryEntity> inventory = inventoryListener.getFullInventoryInfo(id);
        inventoryRepository.delete(inventory.get());
        return ResponseEntity.ok("[Inventory has been deleted!]");
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProducts(@RequestBody ProductsDto productsEvent) {
        ProductsEntity products = ProductsListener.ToEntity(productsEvent);
        ProductsEntity savedProducts = productRepository.save(products);
        ProductsDto responseEvent = ProductsListener.ToDTO(savedProducts);
        return ResponseEntity.ok("[Product has been successfully created!]");
    }

    @GetMapping("/checkProductInfo/{id}")
    public ResponseEntity<?> checkProductInfo(@PathVariable Long id) {
        Optional<ProductsEntity> products = productRepository.findById(id);
        ProductsDto responseEvent = ProductsListener.ToDTO(products.get());
        return ResponseEntity.ok("[Product info:] " + responseEvent);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<ProductsEntity> products = productRepository.findById(id);
        productRepository.delete(products.get());
        return ResponseEntity.ok("[Product has been deleted!]");
    }

    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody CategoriesDto categoriesEvent) {
        CategoriesEntity categories = CategoriesListener.ToEntity(categoriesEvent);
        CategoriesEntity savedCategory = categoriesRepository.save(categories);
        CategoriesDto responseEvent = CategoriesListener.ToDto(savedCategory);
        return ResponseEntity.ok("[Category has been successfully created!]");
    }

    @GetMapping("/checkCategoryInfo/{id}")
    public ResponseEntity<?> checkCategoryInfo(@PathVariable Long id) {
        Optional<CategoriesEntity> categories = categoriesRepository.findById(id);
        CategoriesDto responseEvent = CategoriesListener.ToDto(categories.get());
        return ResponseEntity.ok("[Category info:] " + responseEvent);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Optional<CategoriesEntity> categories = categoriesRepository.findById(id);
        categoriesRepository.delete(categories.get());
        return ResponseEntity.ok("[Category has been deleted!]");
    }
}

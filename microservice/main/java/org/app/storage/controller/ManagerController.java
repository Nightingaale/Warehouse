package org.app.storage.controller;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.CategoriesEvent;
import org.app.storage.event.InventoryEvent;
import org.app.storage.event.ProductsEvent;
import org.app.storage.event.WarehousesEvent;
import org.app.storage.listener.CategoriesListener;
import org.app.storage.listener.InventoryListener;
import org.app.storage.listener.ProductsListener;
import org.app.storage.listener.WarehousesListener;
import org.app.storage.models.Categories;
import org.app.storage.models.Inventory;
import org.app.storage.models.Products;
import org.app.storage.models.Warehouses;
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
    public ResponseEntity<?> createWarehouse(@RequestBody WarehousesEvent warehousesEvent) {
        Warehouses warehouses = WarehousesListener.ToEntity(warehousesEvent);
        Warehouses savedWarehouse = warehousesRepository.save(warehouses);
        WarehousesEvent responseEvent = WarehousesListener.ToDto(savedWarehouse);
        return ResponseEntity.ok("[Warehouse has been successfully created!]");
    }

    @GetMapping("/checkWarehouseInfo/{id}")
    public ResponseEntity<?> checkWarehouseInfo(@PathVariable Long id) {
        Optional<Warehouses> warehouses = warehousesListener.getWarehouseInfo(id);
        WarehousesEvent responseEvent = WarehousesListener.ToDto(warehouses.get());
        return ResponseEntity.ok("[Warehouse info:] " + responseEvent);
    }

    @DeleteMapping("/deleteWarehouse/{id}")
    public ResponseEntity<?> deleteWarehouse(@PathVariable Long id) {
        Optional<Warehouses> warehouses = warehousesListener.getWarehouseInfo(id);
        warehousesRepository.delete(warehouses.get());
        return ResponseEntity.ok("[Warehouse has been deleted!]");
    }

    @PostMapping("/createInventory")
    public ResponseEntity<?> createInventory(@RequestBody InventoryEvent inventoryEvent) {
        Inventory inventory = InventoryListener.ToEntity(inventoryEvent);
        Inventory savedInventory = inventoryRepository.save(inventory);
        InventoryEvent responseEvent = InventoryListener.ToDto(savedInventory);
        return ResponseEntity.ok("[Inventory has been successfully created!]");
    }

    @GetMapping("/checkInventoryInfo/{id}")
    public ResponseEntity<?> checkInventoryInfo(@PathVariable Long id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        InventoryEvent responseEvent = InventoryListener.ToDto(inventory.get());
        return ResponseEntity.ok("[Inventory info:] " + responseEvent);
    }

    @DeleteMapping("/deleteInventory/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long id) {
        Optional<Inventory> inventory = inventoryListener.getFullInventoryInfo(id);
        inventoryRepository.delete(inventory.get());
        return ResponseEntity.ok("[Inventory has been deleted!]");
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProducts(@RequestBody ProductsEvent productsEvent) {
        Products products = ProductsListener.ToEntity(productsEvent);
        Products savedProducts = productRepository.save(products);
        ProductsEvent responseEvent = ProductsListener.ToDTO(savedProducts);
        return ResponseEntity.ok("[Product has been successfully created!]");
    }

    @GetMapping("/checkProductInfo/{id}")
    public ResponseEntity<?> checkProductInfo(@PathVariable Long id) {
        Optional<Products> products = productRepository.findById(id);
        ProductsEvent responseEvent = ProductsListener.ToDTO(products.get());
        return ResponseEntity.ok("[Product info:] " + responseEvent);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<Products> products = productRepository.findById(id);
        productRepository.delete(products.get());
        return ResponseEntity.ok("[Product has been deleted!]");
    }

    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody CategoriesEvent categoriesEvent) {
        Categories categories = CategoriesListener.ToEntity(categoriesEvent);
        Categories savedCategory = categoriesRepository.save(categories);
        CategoriesEvent responseEvent = CategoriesListener.ToDto(savedCategory);
        return ResponseEntity.ok("[Category has been successfully created!]");
    }

    @GetMapping("/checkCategoryInfo/{id}")
    public ResponseEntity<?> checkCategoryInfo(@PathVariable Long id) {
        Optional<Categories> categories = categoriesRepository.findById(id);
        CategoriesEvent responseEvent = CategoriesListener.ToDto(categories.get());
        return ResponseEntity.ok("[Category info:] " + responseEvent);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Optional<Categories> categories = categoriesRepository.findById(id);
        categoriesRepository.delete(categories.get());
        return ResponseEntity.ok("[Category has been deleted!]");
    }
}

package org.app.storage.controller;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.OrdersDto;
import org.app.storage.dto.SuppliersDto;
import org.app.storage.listener.OrdersListener;
import org.app.storage.listener.SuppliersListener;
import org.app.storage.entity.OrdersEntity;
import org.app.storage.entity.SuppliersEntity;
import org.app.storage.repo.SuppliersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sup")
public class SupplierController {

    private final SuppliersRepository suppliersRepository;
    private final SuppliersListener suppliersListener;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody SuppliersDto suppliersEvent) {
        SuppliersEntity supplier = SuppliersListener.ToEntity(suppliersEvent);
        SuppliersEntity savedSupplier = suppliersRepository.save(supplier);
        SuppliersDto responseEvent = SuppliersListener.ToDto(savedSupplier);
        return ResponseEntity.ok("[Your profile has been successfully created!]");
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getCustomerProfile(@PathVariable Long id) {
        Optional<SuppliersEntity> profile = suppliersListener.getFullSupplierProfile(id);
        SuppliersDto responseEvent = SuppliersListener.ToDto(profile.get());
        return ResponseEntity.ok("[Profile info:] " + responseEvent);
    }

    @DeleteMapping("/profile/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Optional<SuppliersEntity> profile = suppliersListener.getFullSupplierProfile(id);
        SuppliersDto responseEvent = SuppliersListener.ToDto(profile.get());
        suppliersRepository.delete(profile.get());
        return ResponseEntity.ok("[Your profile has been successfully deleted!]");
    }

    @GetMapping("/checkOrder/{id}")
    public ResponseEntity<?> checkOrder(@PathVariable Long id) {
        Optional<OrdersEntity> profile = suppliersListener.getFullOrderInfo(id);
        OrdersDto responseEvent = OrdersListener.ToDto(profile.get());
        return ResponseEntity.ok("[Order info:] " + responseEvent);
    }
}

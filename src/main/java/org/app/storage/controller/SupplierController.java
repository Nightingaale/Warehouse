package org.app.storage.controller;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.OrdersEvent;
import org.app.storage.event.SuppliersEvent;
import org.app.storage.listener.OrdersListener;
import org.app.storage.listener.SuppliersListener;
import org.app.storage.models.Orders;
import org.app.storage.models.Suppliers;
import org.app.storage.repo.OrdersRepository;
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
    private final OrdersRepository ordersRepository;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody SuppliersEvent suppliersEvent) {
        Suppliers supplier = SuppliersListener.ToEntity(suppliersEvent);
        Suppliers savedSupplier = suppliersRepository.save(supplier);
        SuppliersEvent responseEvent = SuppliersListener.ToDto(savedSupplier);
        return ResponseEntity.ok("[Your profile has been successfully created!]");
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getCustomerProfile(@PathVariable Long id) {
        Optional<Suppliers> profile = suppliersListener.getFullSupplierProfile(id);
        SuppliersEvent responseEvent = SuppliersListener.ToDto(profile.get());
        return ResponseEntity.ok("[Profile info:] " + responseEvent);
    }

    @DeleteMapping("/profile/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Optional<Suppliers> profile = suppliersListener.getFullSupplierProfile(id);
        SuppliersEvent responseEvent = SuppliersListener.ToDto(profile.get());
        suppliersRepository.delete(profile.get());
        return ResponseEntity.ok("[Your profile has been successfully deleted!]");
    }

    @GetMapping("/checkOrder/{id}")
    public ResponseEntity<?> checkOrder(@PathVariable Long id) {
        Optional<Orders> profile = suppliersListener.getFullOrderInfo(id);
        OrdersEvent responseEvent = OrdersListener.ToDto(profile.get());
        return ResponseEntity.ok("[Order info:] " + responseEvent);
    }
}

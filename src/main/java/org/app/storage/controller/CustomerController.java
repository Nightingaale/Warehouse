package org.app.storage.controller;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.CustomersEvent;
import org.app.storage.event.OrdersEvent;
import org.app.storage.listener.CustomersListener;
import org.app.storage.listener.OrdersListener;
import org.app.storage.models.Customers;
import org.app.storage.models.Orders;
import org.app.storage.repo.CustomersRepository;
import org.app.storage.repo.OrdersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomersRepository customersRepository;
    private final CustomersListener customersListener;
    private final OrdersRepository ordersRepository;

    @PostMapping("/signUp")
    // Spring Security
    public ResponseEntity<?> signUp(@RequestBody CustomersEvent customersEvent) {
        Customers customer = CustomersListener.ToEntity(customersEvent);
        Customers savedCustomer = customersRepository.save(customer);
        CustomersEvent responseEvent = CustomersListener.ToDto(savedCustomer);
        return ResponseEntity.ok("[You have been successfully signed up!]");
    }

    @GetMapping("/profile/{id}")
    // Spring Security
    public ResponseEntity<?> getCustomerProfile(@PathVariable Long id) {
        Optional<Customers> profile = customersListener.getFullCustomerProfile(id);
        CustomersEvent responseEvent = CustomersListener.ToDto(profile.get());
        return ResponseEntity.ok("[Profile info:] " + responseEvent);
    }

    @DeleteMapping("/profile/delete/{id}")
    // Spring Security
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Optional<Customers> profile = customersListener.getFullCustomerProfile(id);
        CustomersEvent responseEvent = CustomersListener.ToDto(profile.get());
        customersRepository.delete(profile.get());
        return ResponseEntity.ok("[Profile has been successfully deleted!]");
    }

    @PostMapping("/createOrder")
    // Spring Security 
    public ResponseEntity<?> createOrder(@RequestBody OrdersEvent ordersEvent) {
        Orders orders = OrdersListener.ToEntity(ordersEvent);
        Orders savedOrder = ordersRepository.save(orders);
        OrdersEvent responseEvent = OrdersListener.ToDto(savedOrder);
        return ResponseEntity.ok("[Your order has been successfully created!]");
    }
}

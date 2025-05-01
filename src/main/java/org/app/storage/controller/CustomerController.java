package org.app.storage.controller;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.CustomersDto;
import org.app.storage.dto.OrdersDto;
import org.app.storage.listener.CustomersListener;
import org.app.storage.listener.OrdersListener;
import org.app.storage.entity.CustomersEntity;
import org.app.storage.entity.OrdersEntity;
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
    public ResponseEntity<?> signUp(@RequestBody CustomersDto customersEvent) {
        CustomersEntity customer = CustomersListener.ToEntity(customersEvent);
        CustomersEntity savedCustomer = customersRepository.save(customer);
        CustomersDto responseEvent = CustomersListener.ToDto(savedCustomer);
        return ResponseEntity.ok("[You have been successfully signed up!]");
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getCustomerProfile(@PathVariable Long id) {
        Optional<CustomersEntity> profile = customersListener.getFullCustomerProfile(id);
        CustomersDto responseEvent = CustomersListener.ToDto(profile.get());
        return ResponseEntity.ok("[Profile info:] " + responseEvent);
    }

    @DeleteMapping("/profile/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Optional<CustomersEntity> profile = customersListener.getFullCustomerProfile(id);
        CustomersDto responseEvent = CustomersListener.ToDto(profile.get());
        customersRepository.delete(profile.get());
        return ResponseEntity.ok("[Profile has been successfully deleted!]");
    }

    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrdersDto ordersEvent) {
        OrdersEntity orders = OrdersListener.ToEntity(ordersEvent);
        OrdersEntity savedOrder = ordersRepository.save(orders);
        OrdersDto responseEvent = OrdersListener.ToDto(savedOrder);
        return ResponseEntity.ok("[Your order has been successfully created!]");
    }
}

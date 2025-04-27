package org.app.storage.listener;


import lombok.RequiredArgsConstructor;
import org.app.storage.event.CustomersEvent;
import org.app.storage.models.Customers;
import org.app.storage.repo.CustomersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomersListener {

    private final CustomersRepository customersRepository;


    public static CustomersEvent ToDto(Customers customer) {
        return new CustomersEvent(
                customer.getCustomerId(),
                customer.getOrderId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }

    public static Customers ToEntity(CustomersEvent event) {
        Customers customer = new Customers();
        customer.setFirstName(event.getFirstName());
        customer.setLastName(event.getLastName());
        customer.setEmail(event.getEmail());
        customer.setPhoneNumber(event.getPhoneNumber());
        return customer;
    }

    public static ResponseEntity<CustomersEvent> create(CustomersEvent customersEvent) {
        return new ResponseEntity<>(customersEvent, HttpStatus.CREATED);
    }


    public Optional<Customers> getFullCustomerProfile(Long id) {
        Optional<Customers> customerOptional = customersRepository.findById(id);

        if (customerOptional.isEmpty()) {
            return Optional.empty();
        }
        Customers customer = customerOptional.get();
        Customers DTO = convertToProfileDto(customer);
        return Optional.of(DTO);
    }

    public static Customers convertToProfileDto(Customers customer) {
        return new Customers(
                customer.getCustomerId(),
                customer.getOrderId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }
}
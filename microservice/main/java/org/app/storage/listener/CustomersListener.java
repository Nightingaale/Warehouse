package org.app.storage.listener;


import lombok.RequiredArgsConstructor;
import org.app.storage.dto.CustomersDto;
import org.app.storage.entity.CustomersEntity;
import org.app.storage.repo.CustomersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomersListener {

    private final CustomersRepository customersRepository;


    public static CustomersDto ToDto(CustomersEntity customer) {
        return new CustomersDto(
                customer.getCustomerId(),
                customer.getOrderId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }

    public static CustomersEntity ToEntity(CustomersDto event) {
        CustomersEntity customer = new CustomersEntity();
        customer.setFirstName(event.getFirstName());
        customer.setLastName(event.getLastName());
        customer.setEmail(event.getEmail());
        customer.setPhoneNumber(event.getPhoneNumber());
        return customer;
    }

    public static ResponseEntity<CustomersDto> create(CustomersDto customersEvent) {
        return new ResponseEntity<>(customersEvent, HttpStatus.CREATED);
    }


    public Optional<CustomersEntity> getFullCustomerProfile(Long id) {
        Optional<CustomersEntity> customerOptional = customersRepository.findById(id);

        if (customerOptional.isEmpty()) {
            return Optional.empty();
        }
        CustomersEntity customer = customerOptional.get();
        CustomersEntity DTO = convertToProfileDto(customer);
        return Optional.of(DTO);
    }

    public static CustomersEntity convertToProfileDto(CustomersEntity customer) {
        return new CustomersEntity(
                customer.getCustomerId(),
                customer.getOrderId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }
}
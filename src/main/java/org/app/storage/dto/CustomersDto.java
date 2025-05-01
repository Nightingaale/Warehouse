package org.app.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.entity.OrdersEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDto {
    private Long customerId;
    private OrdersEntity orderId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
package org.app.storage.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.models.Orders;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersEvent {
    private Long customerId;
    private Orders orderId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
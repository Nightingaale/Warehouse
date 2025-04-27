package org.app.storage.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.models.Orders;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersEvent {
    private Long supplierId;
    private Orders orderId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
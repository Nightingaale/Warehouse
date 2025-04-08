package org.app.storage.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.models.Customers;
import org.app.storage.models.Suppliers;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersEvent {
    private Long orderId;
    private Customers customerId;
    private Suppliers supplierId;
    private Date orderDate;
    private Date expectedDeliveryDate;
    private String totalPrice;
    private String status;
    private String address;
}

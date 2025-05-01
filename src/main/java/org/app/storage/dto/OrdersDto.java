package org.app.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.entity.CustomersEntity;
import org.app.storage.entity.SuppliersEntity;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {
    private Long orderId;
    private CustomersEntity customerId;
    private SuppliersEntity supplierId;
    private Date orderDate;
    private Date expectedDeliveryDate;
    private String totalPrice;
    private String status;
    private String address;
}

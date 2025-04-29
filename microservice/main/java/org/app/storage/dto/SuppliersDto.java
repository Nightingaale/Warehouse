package org.app.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.storage.entity.OrdersEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersDto {
    private Long supplierId;
    private OrdersEntity orderId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
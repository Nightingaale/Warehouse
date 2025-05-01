package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.SuppliersDto;
import org.app.storage.entity.OrdersEntity;
import org.app.storage.entity.SuppliersEntity;
import org.app.storage.repo.OrdersRepository;
import org.app.storage.repo.SuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuppliersListener {

    private final SuppliersRepository suppliersRepository;
    private final OrdersRepository ordersRepository;

    public static SuppliersDto ToDto(SuppliersEntity suppliers) {
        return new SuppliersDto(
                suppliers.getSupplierId(),
                suppliers.getOrderId(),
                suppliers.getName(),
                suppliers.getPhoneNumber(),
                suppliers.getEmail(),
                suppliers.getAddress()
        );
    }

    public static SuppliersEntity ToEntity(SuppliersDto event) {
        SuppliersEntity suppliers = new SuppliersEntity();
        suppliers.setSupplierId(event.getSupplierId());
        suppliers.setOrderId(event.getOrderId());
        suppliers.setName(event.getName());
        suppliers.setPhoneNumber(event.getPhoneNumber());
        suppliers.setEmail(event.getEmail());
        suppliers.setAddress(event.getAddress());
        return suppliers;
    }


    public Optional<SuppliersEntity> getFullSupplierProfile(Long id) {
        Optional<SuppliersEntity> supplierOptional = suppliersRepository.findById(id);

        if (supplierOptional.isEmpty()) {
            return Optional.empty();
        }
        SuppliersEntity supplier = supplierOptional.get();
        SuppliersEntity DTO = convertToProfileDto(supplier);
        return Optional.of(DTO);
    }

    public static SuppliersEntity convertToProfileDto(SuppliersEntity suppliers) {
        return new SuppliersEntity(
                suppliers.getSupplierId(),
                suppliers.getOrderId(),
                suppliers.getName(),
                suppliers.getPhoneNumber(),
                suppliers.getEmail(),
                suppliers.getAddress()
        );
    }


    public Optional<OrdersEntity> getFullOrderInfo(Long id) {
        Optional<OrdersEntity> orderInfo = ordersRepository.findById(id);

        if (orderInfo.isEmpty()) {
            return Optional.empty();
        }
        OrdersEntity order = orderInfo.get();
        OrdersEntity DTO = convertToOrderDto(order);
        return Optional.of(DTO);
    }

    public static OrdersEntity convertToOrderDto(OrdersEntity order) {
        return new OrdersEntity(
                order.getOrderId(),
                order.getCustomerId(),
                order.getSupplierId(),
                order.getOrderDate(),
                order.getExpectedDeliveryDate(),
                order.getTotalPrice(),
                order.getStatus(),
                order.getAddress()
        );
    }
}

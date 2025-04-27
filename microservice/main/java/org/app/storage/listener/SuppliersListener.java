package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.SuppliersEvent;
import org.app.storage.models.Orders;
import org.app.storage.models.Suppliers;
import org.app.storage.repo.OrdersRepository;
import org.app.storage.repo.SuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuppliersListener {

    private final SuppliersRepository suppliersRepository;
    private final OrdersRepository ordersRepository;

    public static SuppliersEvent ToDto(Suppliers suppliers) {
        return new SuppliersEvent(
                suppliers.getSupplierId(),
                suppliers.getOrderId(),
                suppliers.getName(),
                suppliers.getPhoneNumber(),
                suppliers.getEmail(),
                suppliers.getAddress()
        );
    }

    public static Suppliers ToEntity(SuppliersEvent event) {
        Suppliers suppliers = new Suppliers();
        suppliers.setSupplierId(event.getSupplierId());
        suppliers.setOrderId(event.getOrderId());
        suppliers.setName(event.getName());
        suppliers.setPhoneNumber(event.getPhoneNumber());
        suppliers.setEmail(event.getEmail());
        suppliers.setAddress(event.getAddress());
        return suppliers;
    }


    public Optional<Suppliers> getFullSupplierProfile(Long id) {
        Optional<Suppliers> supplierOptional = suppliersRepository.findById(id);

        if (supplierOptional.isEmpty()) {
            return Optional.empty();
        }
        Suppliers supplier = supplierOptional.get();
        Suppliers DTO = convertToProfileDto(supplier);
        return Optional.of(DTO);
    }

    public static Suppliers convertToProfileDto(Suppliers suppliers) {
        return new Suppliers(
                suppliers.getSupplierId(),
                suppliers.getOrderId(),
                suppliers.getName(),
                suppliers.getPhoneNumber(),
                suppliers.getEmail(),
                suppliers.getAddress()
        );
    }


    public Optional<Orders> getFullOrderInfo(Long id) {
        Optional<Orders> orderInfo = ordersRepository.findById(id);

        if (orderInfo.isEmpty()) {
            return Optional.empty();
        }
        Orders order = orderInfo.get();
        Orders DTO = convertToOrderDto(order);
        return Optional.of(DTO);
    }

    public static Orders convertToOrderDto(Orders order) {
        return new Orders(
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

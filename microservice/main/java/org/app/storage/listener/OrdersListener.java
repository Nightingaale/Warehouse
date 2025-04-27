package org.app.storage.listener;


import lombok.RequiredArgsConstructor;
import org.app.storage.event.OrdersEvent;
import org.app.storage.models.Orders;
import org.app.storage.repo.OrdersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersListener {

    private final OrdersRepository ordersRepository;

    public static OrdersEvent ToDto(Orders order) {
        return new OrdersEvent(
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

    public static Orders ToEntity(OrdersEvent event) {
        Orders order = new Orders();
        order.setOrderId(event.getOrderId());
        order.setOrderDate(event.getOrderDate());
        order.setExpectedDeliveryDate(event.getExpectedDeliveryDate());
        order.setTotalPrice(event.getTotalPrice());
        order.setStatus(event.getStatus());
        order.setSupplierId(event.getSupplierId());
        order.setCustomerId(event.getCustomerId());
        order.setAddress(event.getAddress());
        return order;
    }

    public static ResponseEntity<OrdersEvent> create(OrdersEvent ordersEvent) {
        return new ResponseEntity<>(ordersEvent, HttpStatus.CREATED);
    }
}

package org.app.storage.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private CustomersEntity customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplierId", referencedColumnName = "supplierId")
    private SuppliersEntity supplierId;

    @CreationTimestamp
    private Date orderDate;

    @UpdateTimestamp
    private Date expectedDeliveryDate;

    private String totalPrice;
    private String status;
    private String address;
}
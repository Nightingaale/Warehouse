package org.app.storage.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customers customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplierId", referencedColumnName = "supplierId")
    private Suppliers supplierId;

    @CreationTimestamp
    private Date orderDate;

    @UpdateTimestamp
    private Date expectedDeliveryDate;

    private String totalPrice;
    private String status;
    private String address;
}
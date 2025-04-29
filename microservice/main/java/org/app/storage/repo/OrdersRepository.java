package org.app.storage.repo;

import org.app.storage.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
}

package org.app.storage.repo;

import org.app.storage.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
}
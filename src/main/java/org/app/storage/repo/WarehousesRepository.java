package org.app.storage.repo;

import org.app.storage.models.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehousesRepository extends JpaRepository<Warehouses, Long> {
}

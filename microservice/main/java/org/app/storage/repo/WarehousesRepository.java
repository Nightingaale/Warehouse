package org.app.storage.repo;

import org.app.storage.entity.WarehousesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehousesRepository extends JpaRepository<WarehousesEntity, Long> {
}

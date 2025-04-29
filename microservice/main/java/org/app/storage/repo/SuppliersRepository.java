package org.app.storage.repo;

import org.app.storage.entity.SuppliersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<SuppliersEntity, Long> {
}

package org.app.storage.repo;

import org.app.storage.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
}

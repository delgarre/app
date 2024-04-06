package com.inventory.app.db;

import com.inventory.app.model.Waste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository<Waste, Long> {
}

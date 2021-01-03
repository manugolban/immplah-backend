package com.immplah.repositories;

import com.immplah.entities.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorDataRepository extends JpaRepository<SensorData, UUID> {
}

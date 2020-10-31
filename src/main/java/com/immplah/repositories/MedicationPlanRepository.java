package com.immplah.repositories;


import com.immplah.entities.MedicationPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, UUID> {


}

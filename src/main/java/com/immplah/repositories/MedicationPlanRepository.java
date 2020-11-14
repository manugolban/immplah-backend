package com.immplah.repositories;


import com.immplah.entities.MedicationPlan;
import com.immplah.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, UUID> {



}

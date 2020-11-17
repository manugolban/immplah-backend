package com.immplah.repositories;

import com.immplah.entities.Patient;
import com.immplah.entities.PrescribedDrug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrescribedDrugRepository extends JpaRepository<PrescribedDrug, UUID> {
}

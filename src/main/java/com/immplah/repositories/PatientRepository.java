package com.immplah.repositories;


import com.immplah.entities.Caregiver;
import com.immplah.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Patient p SET p.caregiver = NULL WHERE p.caregiver.id = :caregiver_id")
    void deletePatientCaregiver(@Param("caregiver_id") UUID caregiver_id);

    @Query(value = "SELECT p from Patient p WHERE p.user.id = :userId")
    Optional<Patient> findByUserId(@Param("userId") UUID userId);
}

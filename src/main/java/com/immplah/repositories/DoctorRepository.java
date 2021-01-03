package com.immplah.repositories;


import com.immplah.entities.Caregiver;
import com.immplah.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    @Query(value = "SELECT d.id from Doctor d WHERE d.user.id = :userId")
    Optional<UUID> findByUserId(@Param("userId") UUID userId);

    @Query(value = "SELECT d from Doctor d WHERE d.user.id = :userId")
    Optional<Doctor> findDoctorByUserId(@Param("userId") UUID userId);
}

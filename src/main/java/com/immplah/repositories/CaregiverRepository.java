package com.immplah.repositories;

import com.immplah.entities.AppUser;
import com.immplah.entities.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaregiverRepository extends JpaRepository<Caregiver, UUID> {
}

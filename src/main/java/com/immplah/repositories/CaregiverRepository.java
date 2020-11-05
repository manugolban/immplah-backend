package com.immplah.repositories;

import com.immplah.entities.AppUser;
import com.immplah.entities.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

public interface CaregiverRepository extends JpaRepository<Caregiver, UUID> {


}

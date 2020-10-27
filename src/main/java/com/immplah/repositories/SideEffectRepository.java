package com.immplah.repositories;

import com.immplah.entities.Patient;
import com.immplah.entities.SideEffect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SideEffectRepository extends JpaRepository<SideEffect, UUID> {

}
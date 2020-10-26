package com.immplah.repositories;

import com.immplah.entities.AppUser;
import com.immplah.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

}

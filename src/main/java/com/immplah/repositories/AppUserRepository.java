package com.immplah.repositories;

import com.immplah.entities.AppUser;
import com.immplah.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    @Query(value = "SELECT u from AppUser u WHERE u.username = :username")
    Optional<AppUser> findAppUserByUsername(@Param("username") String username);
}

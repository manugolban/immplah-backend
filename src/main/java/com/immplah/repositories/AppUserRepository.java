package com.immplah.repositories;

import com.immplah.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    @Query(value = "SELECT u from AppUser u WHERE u.username = :username")
    Optional<AppUser> findAppUserByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "DELETE from AppUser a  WHERE a.id = :id")
    void deleteAppUserById(@Param("id") UUID id);

    @Query(value = "SELECT u from AppUser u WHERE u.username = :username AND u.password = :password")
    Optional<AppUser> findMatchingUser(@Param("username") String username, @Param("password") String password);
}

package com.immplah.repositories;

import com.immplah.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
    List<Person> findByName(String name);

    /**
     * Example: Write Custom Query
     */
    @Query(value = "SELECT p " +
            "FROM Person p " +
            "WHERE p.name = :name " +
            "AND p.age >= 60  ")
    Optional<Person> findSeniorsByName(@Param("name") String name);


    @Transactional
    @Modifying
    @Query(value = "DELETE from Person p WHERE p.id = :id")
    void deletePersonById(@Param("id") UUID id);

    @Query(value = "DELETE from Person p WHERE p.name = :name")
    Optional<Person> deletePersonByName(@Param("name") String name);
}

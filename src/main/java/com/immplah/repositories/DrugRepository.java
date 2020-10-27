package com.immplah.repositories;

import com.immplah.entities.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface DrugRepository extends JpaRepository<Drug, UUID> {


    @Query(value = "insert into drug_side_effect (side_effect_id, drug_id) VALUES (:sei, :di)", nativeQuery = true)
    void  addDrugSideEffect(@Param("sei") UUID sei, @Param("di") UUID di);


}

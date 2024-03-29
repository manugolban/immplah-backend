package com.immplah.services;

import com.immplah.dtos.DrugDTO;
import com.immplah.dtos.builders.DrugBuilder;
import com.immplah.entities.Drug;
import com.immplah.repositories.DrugRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DrugService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrugService.class);
    private final DrugRepository drugRepository;


    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public List<DrugDTO> findDrugs() {
        List<Drug> drugList = drugRepository.findAll();
        return drugList.stream()
                .map(DrugBuilder::toDrugDTO)
                .collect(Collectors.toList());
    }

    public UUID insert(DrugDTO drugDTO) {
        Drug drug = DrugBuilder.toEntity(drugDTO);
        drug = drugRepository.save(drug);
        LOGGER.debug("Drug with id {} has been inserted into the db", drug.getId());
        return drug.getId();
    }

    public UUID update(DrugDTO drugDTO) {
        Drug drug = DrugBuilder.toEntity(drugDTO);
        drug = drugRepository.save(drug);
        LOGGER.debug("Drug with id {} has been updated", drug.getId());
        return drug.getId();
    }

    public UUID deleteById(UUID drugId) {
        drugRepository.deleteById(drugId);
        LOGGER.debug("Drug with id{} has been deleted!", drugId);
        return drugId;
    }
}

package com.immplah.services;

import com.immplah.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.immplah.dtos.PrescribedDrugDTO;
import com.immplah.dtos.builders.PrescribedDrugBuilder;
import com.immplah.entities.PrescribedDrug;
import com.immplah.repositories.DrugRepository;
import com.immplah.repositories.PrescribedDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PrescribedDrugService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrescribedDrugService.class);
    private final PrescribedDrugRepository  prescribedDrugRepository;
    private final DrugRepository  drugRepository;

    @Autowired
    public PrescribedDrugService(PrescribedDrugRepository prescribedDrugRepository, DrugRepository drugRepository) {
        this.prescribedDrugRepository = prescribedDrugRepository;
        this.drugRepository = drugRepository;
    }

    public List<PrescribedDrugDTO> findPrescribedDrugs() {

        List<PrescribedDrug> prescribedDrugList = prescribedDrugRepository.findAll();
        return prescribedDrugList.stream()
                .map(PrescribedDrugBuilder::toPrescribedDrugDTO)
                .collect(Collectors.toList());

    }

    public PrescribedDrugDTO findPrescribedDrugById(UUID id) {

        Optional<PrescribedDrug> prosumerOptional = prescribedDrugRepository.findById(id);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Prescribed Drug  with id {} was not found in db", id);
            throw new ResourceNotFoundException(PrescribedDrug.class.getSimpleName() + " with id: " + id);
        }
        return PrescribedDrugBuilder.toPrescribedDrugDTO(prosumerOptional.get());

    }

    public UUID insert(PrescribedDrugDTO prescribedDrugDTO) {
        PrescribedDrug prescribedDrug = PrescribedDrugBuilder.toEntity(prescribedDrugDTO);
        prescribedDrug = prescribedDrugRepository.save(prescribedDrug);
        LOGGER.debug("Prescribed Drug with id {} was inserted in db", prescribedDrug.getId());
        return prescribedDrug.getId();
    }
}

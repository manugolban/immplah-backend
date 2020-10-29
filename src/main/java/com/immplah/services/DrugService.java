package com.immplah.services;

import com.immplah.dtos.DrugDTO;
import com.immplah.dtos.SideEffectDTO;
import com.immplah.dtos.builders.DrugBuilder;
import com.immplah.dtos.builders.SideEffectBuilder;
import com.immplah.entities.Drug;
import com.immplah.entities.SideEffect;
import com.immplah.repositories.DrugRepository;
import com.immplah.repositories.SideEffectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DrugService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DrugService.class);
    private final DrugRepository drugRepository;
    private final SideEffectRepository sideEffectRepository;
  //  private final DrugSideEffectRepository drugSideEffectRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository, SideEffectRepository sideEffectRepository) {

        this.drugRepository = drugRepository;
        this.sideEffectRepository = sideEffectRepository;
       // this.drugSideEffectRepository = drugSideEffectRepository;
    }

    public List<DrugDTO> findDrugs() {
        List<Drug> drugList = drugRepository.findAll();
        return drugList.stream()
                .map(DrugBuilder::toDrugDTO)
                .collect(Collectors.toList());
    }

    public UUID insert(DrugDTO drugDTO) {

        Drug drug = DrugBuilder.toEntity(drugDTO);
        List<SideEffect> sideEffectsList = new ArrayList<>();
        for(SideEffectDTO se: drugDTO.getSideEffects()) {
            sideEffectsList.add(SideEffectBuilder.toEntity(se));
            //sideEffectsList.add(sideEffectRepository.findById(se.getId()).get());
        }
        drug.setSideEffects(sideEffectsList);
        drug = drugRepository.save(drug);
        LOGGER.debug("Drug with id {} has been inserted into the db", drug.getId());
        return drug.getId();
    }
}

package com.immplah.dtos.builders;

import com.immplah.dtos.DrugDTO;
import com.immplah.entities.Drug;

public class DrugBuilder {

    public DrugBuilder () {

    }

    public static DrugDTO toDrugDTO(Drug drug) {
        return new DrugDTO(drug.getId(),
                drug.getName(),
                drug.getConcentrations(),
                drug.getSideEffects());
    }

    public static Drug toEntity(DrugDTO drugDTO) {

        return new Drug(drugDTO.getId(),
                drugDTO.getName(),
                drugDTO.getConcentrations(),
                drugDTO.getSideEffects());
    }
}

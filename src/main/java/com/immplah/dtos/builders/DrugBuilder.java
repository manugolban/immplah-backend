package com.immplah.dtos.builders;

import com.immplah.dtos.DrugDTO;
import com.immplah.dtos.SideEffectDTO;
import com.immplah.entities.Drug;
import com.immplah.entities.SideEffect;

import java.util.ArrayList;
import java.util.List;

public class DrugBuilder {

    public DrugBuilder () {

    }

    public static DrugDTO toDrugDTO(Drug drug) {
        List<SideEffectDTO> dtos = new ArrayList<>();
        for(SideEffect e: drug.getSideEffects()) {
            dtos.add(SideEffectBuilder.toSideEffectDTO(e));
        }

        return new DrugDTO(drug.getId(),
                drug.getName(),
                drug.getConcentrations(),
                dtos);
    }

    public static Drug toEntity(DrugDTO drugDTO) {

        return new Drug(drugDTO.getId(),
                drugDTO.getName(),
                drugDTO.getConcentrations());
    }
}

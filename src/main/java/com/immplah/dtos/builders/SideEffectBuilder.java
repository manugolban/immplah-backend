package com.immplah.dtos.builders;

import com.immplah.dtos.DrugDTO;
import com.immplah.dtos.SideEffectDTO;
import com.immplah.entities.Drug;
import com.immplah.entities.SideEffect;

import java.util.List;

public class SideEffectBuilder {

    public SideEffectBuilder() {

    }

    public static SideEffectDTO toSideEffectDTO(SideEffect sideEffect) {
        return new SideEffectDTO(sideEffect.getId(),
                sideEffect.getName()
                );
    }

    public static SideEffect toEntity(SideEffectDTO sideEffectDTO) {

        return new SideEffect(sideEffectDTO.getId(),
                sideEffectDTO.getName()
                );
    }
}

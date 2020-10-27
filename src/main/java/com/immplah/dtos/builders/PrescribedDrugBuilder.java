package com.immplah.dtos.builders;

import com.immplah.dtos.PrescribedDrugDTO;
import com.immplah.entities.PrescribedDrug;

public class PrescribedDrugBuilder {

    public PrescribedDrugBuilder() {

    }

    public static PrescribedDrugDTO toPrescribedDrugDTO(PrescribedDrug prescribedDrug) {

        return new PrescribedDrugDTO(prescribedDrug.getId(),
                DrugBuilder.toDrugDTO(prescribedDrug.getDrug()),
                prescribedDrug.isMorning(),
                prescribedDrug.isMidDay(),
                prescribedDrug.isEvening(),
                prescribedDrug.isBedTime(),
                prescribedDrug.getDosage()
        );

    }

    public static PrescribedDrug toEntity(PrescribedDrugDTO prescribedDrugDTO) {
        return new PrescribedDrug(
                prescribedDrugDTO.getId(),
                DrugBuilder.toEntity(prescribedDrugDTO.getDrug()),
                prescribedDrugDTO.isMorning(),
                prescribedDrugDTO.isMidDay(),
                prescribedDrugDTO.isEvening(),
                prescribedDrugDTO.isEvening(),
                prescribedDrugDTO.getDosage()
        );
    }
}

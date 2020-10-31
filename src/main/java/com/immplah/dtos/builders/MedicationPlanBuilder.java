package com.immplah.dtos.builders;

import com.immplah.dtos.MedicationPlanDTO;
import com.immplah.dtos.PrescribedDrugDTO;
import com.immplah.entities.MedicationPlan;
import com.immplah.entities.PrescribedDrug;

import java.util.ArrayList;
import java.util.List;

public class MedicationPlanBuilder {

    public MedicationPlanBuilder() {

    }

    public static MedicationPlanDTO toMedicationPlanDTO(MedicationPlan medicationPlan) {
        List<PrescribedDrugDTO> dtos = new ArrayList<>();
        for(PrescribedDrug p: medicationPlan.getPrescribedDrugs()) {
            dtos.add(PrescribedDrugBuilder.toPrescribedDrugDTO(p));
        }
        return new MedicationPlanDTO(medicationPlan.getId(),
                medicationPlan.getPeriodFrom(),
                medicationPlan.getPeriodTo(),
                DoctorBuilder.toDoctorDTO(medicationPlan.getDoctor()),
                PatientBuilder.toPatientDTO(medicationPlan.getPatient()),
                dtos);
    }

    public static MedicationPlan toEntity(MedicationPlanDTO medicationPlanDTO) {

        return new MedicationPlan(medicationPlanDTO.getId(),
                medicationPlanDTO.getPeriodFrom(),
                medicationPlanDTO.getPeriodTo()
                );
    }
}

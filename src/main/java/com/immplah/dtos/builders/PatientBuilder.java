package com.immplah.dtos.builders;

import com.immplah.dtos.*;
import com.immplah.entities.Caregiver;
import com.immplah.entities.Doctor;
import com.immplah.entities.MedicationPlan;
import com.immplah.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientBuilder {

    public PatientBuilder() {
    }

    public static PatientDTO toPatientDTO(Patient patient) {
        AppUserDTO appUserDTO = AppUserBuilder.toAppUserDTO(patient.getUser());
        CaregiverDTO caregiverDTO = CaregiverBuilder.toCaregiverDTO(patient.getCaregiver());

        List<MedicationPlanDTO> medicationPlanDTOList = new ArrayList<>();
        for(MedicationPlan m: patient.getMedicationPlans()) {
            medicationPlanDTOList.add(MedicationPlanBuilder.toMedicationPlanDTO(m));
        }
        return new PatientDTO(patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDOB(),
                patient.getGender(),
                patient.getAddress(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getMedicalRecord(),
                appUserDTO,
                caregiverDTO,
                medicationPlanDTOList
        );
    }

    public static Patient toEntity(PatientDTO patientDTO) {
        return new Patient(patientDTO.getId(),
                patientDTO.getFirstName(),
                patientDTO.getLastName(),
                patientDTO.getDOB(),
                patientDTO.getGender(),
                patientDTO.getAddress(),
                patientDTO.getEmail(),
                patientDTO.getPhone(),
                patientDTO.getMedicalRecord()
        );
               
    }
}

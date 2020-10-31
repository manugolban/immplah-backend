package com.immplah.dtos.builders;

import com.immplah.dtos.*;
import com.immplah.entities.Caregiver;
import com.immplah.entities.MedicationPlan;
import com.immplah.entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientBuilder {

    public PatientBuilder() {
    }

    public static PatientDTO toPatientDTO(Patient patient) {


        return new PatientDTO(patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDob(),
                patient.getGender(),
                patient.getAddress(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getMedicalRecord(),
                AppUserBuilder.toAppUserDTO(patient.getUser()),
                patient.getCaregiver().getId()
        );
    }

    public static Patient toEntity(PatientDTO patientDTO) {
        return new Patient(patientDTO.getId(),
                patientDTO.getFirstName(),
                patientDTO.getLastName(),
                patientDTO.getDob(),
                patientDTO.getGender(),
                patientDTO.getAddress(),
                patientDTO.getEmail(),
                patientDTO.getPhone(),
                patientDTO.getMedicalRecord()
        );
               
    }


}

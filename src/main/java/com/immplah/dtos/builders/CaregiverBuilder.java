package com.immplah.dtos.builders;

import com.immplah.dtos.AppUserDTO;
import com.immplah.dtos.CaregiverDTO;
import com.immplah.dtos.PatientDTO;
import com.immplah.entities.AppUser;
import com.immplah.entities.Caregiver;
import com.immplah.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class CaregiverBuilder {

    public CaregiverBuilder() {

    }

    public static CaregiverDTO toCaregiverDTO(Caregiver caregiver) {

        List<PatientDTO> dtos = new ArrayList<>();
        AppUserDTO appUserDTO = AppUserBuilder.toAppUserDTO(caregiver.getUser());
        for(Patient p: caregiver.getPatientList()) {
            PatientDTO patientDTO = PatientBuilder.toPatientDTO(p);
            patientDTO.setUser(null);
            dtos.add(patientDTO);
        }
        return new CaregiverDTO(caregiver.getId(),
                caregiver.getFirstName(),
                caregiver.getLastName(),
                caregiver.getDOB(),
                caregiver.getGender(),
                caregiver.getAddress(),
                caregiver.getEmail(),
                caregiver.getPhone(),
                appUserDTO,
                dtos
                );
    }

    public static Caregiver toEntity(CaregiverDTO caregiverDTO) {
        return new Caregiver(caregiverDTO.getId(),
                caregiverDTO.getFirstName(),
                caregiverDTO.getLastName(),
                caregiverDTO.getDOB(),
                caregiverDTO.getGender(),
                caregiverDTO.getAddress(),
                caregiverDTO.getEmail(),
                caregiverDTO.getPhone()
        );
    }

}

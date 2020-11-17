package com.immplah.dtos.builders;

import com.immplah.dtos.AppUserDTO;
import com.immplah.dtos.DoctorDTO;
import com.immplah.entities.Doctor;

public class DoctorBuilder {

    public DoctorBuilder() {
    }

    public static DoctorDTO toDoctorDTO(Doctor doctor) {
        AppUserDTO appUserDTO = AppUserBuilder.toAppUserDTO(doctor.getUser());
        return new DoctorDTO(doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getDOB(),
                doctor.getGender(),
                doctor.getAddress(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getSpecialty(),
                appUserDTO
                );
    }

    public static Doctor toEntity(DoctorDTO doctorDTO) {
            return new Doctor(doctorDTO.getId(),
                    doctorDTO.getFirstName(),
                    doctorDTO.getLastName(),
                    doctorDTO.getDOB(),
                    doctorDTO.getGender(),
                    doctorDTO.getAddress(),
                    doctorDTO.getEmail(),
                    doctorDTO.getPhone(),
                    doctorDTO.getSpecialty());
    }
}




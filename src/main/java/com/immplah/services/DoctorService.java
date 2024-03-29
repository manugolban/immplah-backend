package com.immplah.services;

import com.immplah.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.immplah.dtos.DoctorDTO;
import com.immplah.dtos.MedicationPlanDTO;
import com.immplah.dtos.builders.AppUserBuilder;
import com.immplah.dtos.builders.DoctorBuilder;
import com.immplah.dtos.builders.MedicationPlanBuilder;
import com.immplah.entities.AppUser;
import com.immplah.entities.Doctor;
import com.immplah.repositories.AppUserRepository;
import com.immplah.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);
    private final DoctorRepository doctorRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, AppUserRepository appUserRepository) {
        this.doctorRepository = doctorRepository;
        this.appUserRepository = appUserRepository;
    }

    public List<DoctorDTO> findDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream()
                .map(DoctorBuilder::toDoctorDTO)
                .collect(Collectors.toList());

    }

    public DoctorDTO findDoctorById(UUID id){
        Optional<Doctor> prosumerOptional = doctorRepository.findById(id);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Doctor with id {} was not found in db!", id);
            throw new ResourceNotFoundException(Doctor.class.getSimpleName() + " with id: " + id);
        }
        return DoctorBuilder.toDoctorDTO(prosumerOptional.get());
    }

    public UUID findDoctorIdByUserId(UUID id) {
        Optional<UUID> prosumerOptional = doctorRepository.findByUserId(id);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Doctor with user_id  {} was not found in db!", id);
            throw new ResourceNotFoundException(Doctor.class.getSimpleName() + " with id: " + id);
        }
        return prosumerOptional.get();
    }

    public List<MedicationPlanDTO> findMedicationPlansByDoctorId(UUID id) {
        Optional<Doctor> prosumerOptional = doctorRepository.findById(id);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Doctor with id {} was not found in db", id);
            throw new ResourceNotFoundException(Doctor.class.getSimpleName() + " with id: " + id);
        } else {
            return prosumerOptional.get().getMedicationPlans().stream()
                    .map(MedicationPlanBuilder::toMedicationPlanWithNamesDTO)
                    .collect(Collectors.toList());
        }
    }

    public UUID insert(DoctorDTO doctorDTO){
        AppUser appUser = AppUserBuilder.toEntity(doctorDTO.getUser());
        appUser.setPassword(encoder.encode(appUser.getPassword()));
        appUser = appUserRepository.save(appUser);
        Doctor doctor = DoctorBuilder.toEntity(doctorDTO);
       // appUser.setDoctor(doctor);
        doctor.setUser(appUser);

        doctor = doctorRepository.save(doctor);
        LOGGER.debug("Doctor with id {} was inserted in db!", doctor.getId());
        return doctor.getId();
    }

    public UUID update(DoctorDTO doctorDTO){
        AppUser appUser = AppUserBuilder.toEntity(doctorDTO.getUser());
        appUser = appUserRepository.save(appUser);

        Doctor doctor = DoctorBuilder.toEntity(doctorDTO);
        doctor.setUser(appUser);

        doctor = doctorRepository.save(doctor);
        LOGGER.debug("Doctor with id {} has been updated!", doctor.getId());
        return doctor.getId();
    }

    public UUID deleteById(UUID id) {
        doctorRepository.deleteById(id);
        LOGGER.debug("Doctor with id{} has been deleted!", id);
        return id;
    }
}

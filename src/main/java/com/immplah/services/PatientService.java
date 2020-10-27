package com.immplah.services;

import com.immplah.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.immplah.dtos.PatientDTO;
import com.immplah.dtos.builders.AppUserBuilder;
import com.immplah.dtos.builders.PatientBuilder;
import com.immplah.dtos.builders.PersonBuilder;
import com.immplah.entities.AppUser;
import com.immplah.entities.Patient;
import com.immplah.entities.Person;
import com.immplah.repositories.AppUserRepository;
import com.immplah.repositories.PatientRepository;
import com.immplah.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    private final PatientRepository patientRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, AppUserRepository appUserRepository) {
        this.patientRepository = patientRepository;
        this.appUserRepository = appUserRepository;
    }

    public List<PatientDTO> findPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream()
                .map(PatientBuilder::toPatientDTO)
                .collect(Collectors.toList());

    }

    public PatientDTO findPatientById(UUID id){
        Optional<Patient> prosumerOptional = patientRepository.findById(id);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Patient  with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }
        return PatientBuilder.toPatientDTO(prosumerOptional.get());
    }

    public UUID insert(PatientDTO patientDTO){
        AppUser appUser = AppUserBuilder.toEntity(patientDTO.getUser());
        appUser = appUserRepository.save(appUser);

        Patient patient = PatientBuilder.toEntity(patientDTO);
        patient.setUser(appUser);

        patient = patientRepository.save(patient);
        LOGGER.debug("Patient with id {} was inserted in db", patient.getId());
        return patient.getId();
    }
}

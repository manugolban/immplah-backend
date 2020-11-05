package com.immplah.services;

import com.immplah.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.immplah.dtos.CaregiverDTO;
import com.immplah.dtos.builders.AppUserBuilder;
import com.immplah.dtos.builders.CaregiverBuilder;
import com.immplah.entities.AppUser;
import com.immplah.entities.Caregiver;
import com.immplah.repositories.AppUserRepository;
import com.immplah.repositories.CaregiverRepository;
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
public class CaregiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    private final CaregiverRepository caregiverRepository;
    private final PatientRepository patientRepository;
    private final AppUserRepository appUserRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository, PatientRepository patientRepository, AppUserRepository appUserRepository) {
        this.caregiverRepository = caregiverRepository;
        this.patientRepository = patientRepository;
        this.appUserRepository = appUserRepository;
    }

    public List<CaregiverDTO> findCaregivers() {

        List<Caregiver> caregiverList = caregiverRepository.findAll();
        return caregiverList.stream()
                .map(CaregiverBuilder::toCaregiverDTO)
                .collect(Collectors.toList());

    }

    public CaregiverDTO findCaregiverById(UUID id) {

        Optional<Caregiver> prosumerOptional = caregiverRepository.findById(id);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Caregiver with id {} was not found in db!", id);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + id);
        }
        return CaregiverBuilder.toCaregiverDTO(prosumerOptional.get());

    }

    public UUID insert(CaregiverDTO caregiverDTO) {
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
        AppUser appUser = AppUserBuilder.toEntity(caregiverDTO.getUser());
        appUser = appUserRepository.save(appUser);
        caregiver.setUser(appUser);
        caregiver = caregiverRepository.save(caregiver);
        LOGGER.debug("Caregiver with id {} was inserted in db!", caregiver.getId());
        return caregiver.getId();
    }

    public UUID update(CaregiverDTO caregiverDTO) {
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
        caregiver.setUser(AppUserBuilder.toEntity(caregiverDTO.getUser()));
        caregiver = caregiverRepository.save(caregiver);
        LOGGER.debug("Caregiver with id {} was been updated!", caregiver.getId());
        return caregiver.getId();
    }

    public UUID delete(UUID caregiverId) {
        patientRepository.deletePatientCaregiver(caregiverId);
        caregiverRepository.deleteById(caregiverId);
        LOGGER.debug("Caregiver with id{} has been deleted!", caregiverId);
        return caregiverId;
    }
}

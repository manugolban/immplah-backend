package com.immplah.services;

import com.immplah.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.immplah.dtos.MedicationPlanDTO;
import com.immplah.dtos.builders.*;
import com.immplah.entities.AppUser;
import com.immplah.entities.MedicationPlan;
import com.immplah.entities.Person;
import com.immplah.entities.PrescribedDrug;
import com.immplah.repositories.*;
import com.immplah.repositories.MedicationPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationPlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    private final MedicationPlanRepository  medicationPlanRepository;
    private final DoctorRepository  doctorRepository;
    private final PatientRepository patientRepository;
    private final PrescribedDrugRepository prescribedDrugRepository;

    @Autowired
    public MedicationPlanService(MedicationPlanRepository medicationPlanRepository, DoctorRepository doctorRepository, PatientRepository patientRepository, PrescribedDrugRepository prescribedDrugRepository) {
        this.medicationPlanRepository = medicationPlanRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.prescribedDrugRepository = prescribedDrugRepository;
    }

    public List<MedicationPlanDTO> findMedicationPlans() {

        List<MedicationPlan> medicationPlanList = medicationPlanRepository.findAll();
        return medicationPlanList.stream()
                .map(MedicationPlanBuilder::toMedicationPlanDTO)
                .collect(Collectors.toList());

    }

    public MedicationPlanDTO findMedicationPlanById(UUID id) {

        Optional<MedicationPlan> prosumerOptional = medicationPlanRepository.findById(id);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Medical Plan  with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationPlan.class.getSimpleName() + " with id: " + id);
        }
        return MedicationPlanBuilder.toMedicationPlanDTO(prosumerOptional.get());

    }

    public UUID insert(MedicationPlanDTO medicationPlanDTO) {
        MedicationPlan medicationPlan = MedicationPlanBuilder.toEntity(medicationPlanDTO);

        medicationPlan.setDoctor(doctorRepository.findById(medicationPlanDTO.getDoctorId()).get());
        medicationPlan.setPatient(patientRepository.findById(medicationPlanDTO.getPatientId()).get());

        medicationPlan = medicationPlanRepository.save(medicationPlan);

        List<PrescribedDrug> prescribedDrugList = medicationPlanDTO.getPrescribedDrugs().stream()
                .map(PrescribedDrugBuilder::toEntity)
                .collect(Collectors.toList());

        for(PrescribedDrug p: prescribedDrugList) {
            p.setMedicationPlan(medicationPlan);
            p = prescribedDrugRepository.save(p);
        }

        LOGGER.debug("Medical Plan with id {} was inserted in db", medicationPlan.getId());
        return medicationPlan.getId();
    }
}

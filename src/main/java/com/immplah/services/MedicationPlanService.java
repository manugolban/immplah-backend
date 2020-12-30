package com.immplah.services;

import com.immplah.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.immplah.dtos.DayPlanDTO;
import com.immplah.dtos.DayPlanDrugDTO;
import com.immplah.dtos.MedicationPlanDTO;
import com.immplah.dtos.builders.*;
import com.immplah.entities.MedicationPlan;
import com.immplah.entities.Patient;
import com.immplah.entities.PrescribedDrug;
import com.immplah.repositories.*;
import com.immplah.repositories.MedicationPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MedicationPlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaregiverService.class);
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
            LOGGER.error("Medication Plan  with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationPlan.class.getSimpleName() + " with id: " + id);
        }
        return MedicationPlanBuilder.toMedicationPlanDTO(prosumerOptional.get());

    }

    public DayPlanDTO getDayPlan(String todaysDate, UUID patientId) {

        Optional<Patient> prosumerOptional = patientRepository.findById(patientId);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Patient with id {} was not found in db", patientId);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + patientId);
        }

        Calendar calendar = Calendar.getInstance();
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        DayPlanDTO dayPlan = new DayPlanDTO(todaysDate, dayOfWeek);

        for(MedicationPlan m : prosumerOptional.get().getMedicationPlans()) {
            Date from = null;
            Date to = null;
            Date current = null;
            try {
                current = new SimpleDateFormat("dd/MM/yyyy").parse(todaysDate);
                from = new SimpleDateFormat("dd/MM/yyyy").parse(m.getPeriodFrom());
                to = new SimpleDateFormat("dd/MM/yyyy").parse(m.getPeriodTo());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (current.after(from) && current.before(to)) {
                for(PrescribedDrug p: m.getPrescribedDrugs()) {
                    if (p.getDays().contains(dayOfWeek)) {
                        dayPlan.getMedication().add(new DayPlanDrugDTO(p.getDrug().getName(), p.getDosage(),p.isMorning(), p.isBedTime(), p.isEvening(), p.isBedTime()));
                    }
                }
            }
        }

        return dayPlan;
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

        LOGGER.debug("Medication Plan with id {} was inserted in db", medicationPlan.getId());
        return medicationPlan.getId();
    }
}

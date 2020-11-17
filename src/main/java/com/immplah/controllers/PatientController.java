package com.immplah.controllers;

import com.immplah.dtos.MedicationPlanDTO;
import com.immplah.dtos.PatientDTO;
import com.immplah.entities.MedicationPlan;
import com.immplah.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientDTO>> getPatients(){
        List<PatientDTO> dtos = patientService.findPatients();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") UUID PatientId){
        PatientDTO dto = patientService.findPatientById(PatientId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/plans/{id}")
    public ResponseEntity<List<MedicationPlanDTO>> getPlansByPatientId(@PathVariable("id") UUID patientId){
        List<MedicationPlanDTO> dtos = patientService.findMedicationPlansByPatientId(patientId);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/plans/user={id}")
    public ResponseEntity<List<MedicationPlanDTO>> getPlansByUserId(@PathVariable("id") UUID userId){
        List<MedicationPlanDTO> dtos = patientService.findMedicationPlansByUserId(userId);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody PatientDTO patientDTO) {
        UUID patientId = patientService.insert(patientDTO);
        return new ResponseEntity<>(patientId, HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<UUID> updateProsumer(@Valid @RequestBody PatientDTO patientDTO) {
        UUID patientId = patientService.update(patientDTO);
        return new ResponseEntity<>(patientId, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UUID> deletePatient(@PathVariable("id") UUID PatientId) {
        UUID patientId = patientService.deleteById(PatientId);
        return new ResponseEntity<>(patientId, HttpStatus.OK);
    }
}

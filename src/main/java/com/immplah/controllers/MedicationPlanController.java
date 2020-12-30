package com.immplah.controllers;

import com.immplah.dtos.DayPlanDTO;
import com.immplah.dtos.MedicationPlanDTO;
import com.immplah.services.MedicationPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicationplan")
public class MedicationPlanController {

    private final MedicationPlanService medicationPlanService;

    @Autowired
    public MedicationPlanController(MedicationPlanService medicationPlanService) {
        this.medicationPlanService = medicationPlanService;
    }

    @GetMapping()
    public ResponseEntity<List<MedicationPlanDTO>> getMedicationPlans(){
        List<MedicationPlanDTO> dtos = medicationPlanService.findMedicationPlans();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicationPlanDTO> getMedicationPlan(@PathVariable("id") UUID MedicationPlanId){
        MedicationPlanDTO dto = medicationPlanService.findMedicationPlanById(MedicationPlanId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody MedicationPlanDTO medicationPlanDTO) {
        UUID medicationPlanId = medicationPlanService.insert(medicationPlanDTO);
        return new ResponseEntity<>(medicationPlanId, HttpStatus.CREATED);
    }
}

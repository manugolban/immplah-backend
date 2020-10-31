package com.immplah.controllers;

import com.immplah.dtos.CaregiverDTO;
import com.immplah.services.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")
public class CaregiverController {

    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService) {
        this.caregiverService = caregiverService;
    }

    @GetMapping()
    public ResponseEntity<List<CaregiverDTO>> getCaregivers(){
        List<CaregiverDTO> dtos = caregiverService.findCaregivers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CaregiverDTO> getDoctor(@PathVariable("id") UUID caregiverId){
        CaregiverDTO dto = caregiverService.findCaregiverById(caregiverId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody CaregiverDTO caregiverDTO) {
        UUID patientId = caregiverService.insert(caregiverDTO);
        return new ResponseEntity<>(patientId, HttpStatus.CREATED);
    }
}

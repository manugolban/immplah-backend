package com.immplah.controllers;

import com.immplah.dtos.DoctorDTO;
import com.immplah.dtos.DrugDTO;
import com.immplah.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/drug")
public class DrugController {

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping()
    public ResponseEntity<List<DrugDTO>> getDrugs(){
        List<DrugDTO> dtos = drugService.findDrugs();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody DrugDTO drugDTO) {
        UUID drugId = drugService.insert(drugDTO);
        return new ResponseEntity<UUID>(drugId, HttpStatus.CREATED);
    }
}

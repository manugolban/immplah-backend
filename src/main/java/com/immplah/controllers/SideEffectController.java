package com.immplah.controllers;

import com.immplah.dtos.DoctorDTO;
import com.immplah.dtos.SideEffectDTO;
import com.immplah.services.SideEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/sideeffect")
public class SideEffectController {

    private final SideEffectService sideEffectService;

    @Autowired
    public SideEffectController(SideEffectService sideEffectService) {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping()
    public ResponseEntity<List<SideEffectDTO>> getSideEffects(){
        List<SideEffectDTO> dtos = sideEffectService.findSideEffects();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody SideEffectDTO sideEffectDTO) {
        UUID sideEffectId = sideEffectService.insert(sideEffectDTO);
        return new ResponseEntity<UUID>(sideEffectId, HttpStatus.CREATED);
    }
}

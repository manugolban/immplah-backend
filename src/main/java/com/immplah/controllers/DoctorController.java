package com.immplah.controllers;

import com.immplah.dtos.DoctorDTO;
import com.immplah.dtos.MedicationPlanDTO;
import com.immplah.entities.Doctor;
import com.immplah.services.AppUserService;
import com.immplah.services.DoctorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {

    private final DoctorService doctorService;


    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;

    }

    @GetMapping()
    public ResponseEntity<List<DoctorDTO>> getDoctors(){
        List<DoctorDTO> dtos = doctorService.findDoctors();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable("id") UUID DoctorId){
        DoctorDTO dto = doctorService.findDoctorById(DoctorId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/plans/{id}")
    public ResponseEntity<List<MedicationPlanDTO>> getPlansByPatientId(@PathVariable("id") UUID doctorId){
        List<MedicationPlanDTO> dtos = doctorService.findMedicationPlansByDoctorId(doctorId);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/user={id}")
    public ResponseEntity<UUID> getDoctorIdByUserId(@PathVariable("id") UUID userId) {

        UUID doctorId = doctorService.findDoctorIdByUserId(userId);
        return new ResponseEntity<>(doctorId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody DoctorDTO doctorDTO) {
        UUID doctorId = doctorService.insert(doctorDTO);
        return new ResponseEntity<>(doctorId, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UUID> updateProsumer(@Valid @RequestBody DoctorDTO doctorDTO) {
        UUID doctorId = doctorService.update(doctorDTO);
        return new ResponseEntity<>(doctorId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UUID> deleteDoctor(@PathVariable("id") UUID DoctorId) {
        UUID doctorId = doctorService.deleteById(DoctorId);
        return new ResponseEntity<>(doctorId, HttpStatus.OK);
    }
}

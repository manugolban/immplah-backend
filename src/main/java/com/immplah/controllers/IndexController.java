package com.immplah.controllers;

import com.immplah.dtos.AppUserDTO;
import com.immplah.dtos.DrugDTO;
import com.immplah.entities.AppUser;
import com.immplah.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RestController
@CrossOrigin
public class IndexController {

    private final AppUserService appUserService;

    @Autowired
    public IndexController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @GetMapping(value = "/")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("IMMPlaH is running...", HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AppUserDTO> login(@Valid @RequestBody AppUserDTO appUserDTO) {
        AppUserDTO foundUser = appUserService.findMatchingUser(appUserDTO);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
}

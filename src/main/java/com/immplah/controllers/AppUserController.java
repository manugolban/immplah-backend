package com.immplah.controllers;

import com.immplah.dtos.AppUserDTO;
import com.immplah.entities.AppUser;
import com.immplah.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) { this.appUserService = appUserService; }


    @GetMapping()
    public ResponseEntity<List<AppUserDTO>> getAppUsers() {
        List<AppUserDTO> dtos = appUserService.findAppUsers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AppUserDTO> getAppUser(@PathVariable("id") UUID appUserId) {
        AppUserDTO dto = appUserService.findAppUserById(appUserId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody AppUserDTO appUserDTO) {
        UUID appUserId = appUserService.insert(appUserDTO);
        return new ResponseEntity<>(appUserId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UUID> deleteUser(@PathVariable("id") UUID appUserId) {
        appUserId = appUserService.delete(appUserId);
        return new ResponseEntity<>(appUserId, HttpStatus.OK);
    }
}

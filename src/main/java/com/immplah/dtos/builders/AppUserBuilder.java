package com.immplah.dtos.builders;


import com.immplah.dtos.AppUserDTO;
import com.immplah.entities.AppUser;

public class AppUserBuilder {

    public AppUserBuilder() {
    }

    public static AppUserDTO toAppUserDTO(AppUser appUser) {
        return new AppUserDTO(appUser.getId(),appUser.getUsername(), appUser.getPassword(), appUser.getUserType());
    }

    public static AppUser toEntity(AppUserDTO appUserDTO) {
        return new AppUser(appUserDTO.getId(), appUserDTO.getUsername(), appUserDTO.getPassword(), appUserDTO.getUserType());
    }

}

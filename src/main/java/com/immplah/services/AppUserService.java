package com.immplah.services;


import com.immplah.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.immplah.dtos.AppUserDTO;
import com.immplah.dtos.LoginResponseDTO;
import com.immplah.dtos.builders.AppUserBuilder;
import com.immplah.entities.AppUser;
import com.immplah.repositories.AppUserRepository;
import com.immplah.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class AppUserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserService.class);
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {

        this.appUserRepository = appUserRepository;

    }

    public List<AppUserDTO> findAppUsers() {
        List<AppUser> appUserList = appUserRepository.findAll();
        return appUserList.stream()
                .map(AppUserBuilder::toAppUserDTO)
                .collect(Collectors.toList());

    }

    public AppUserDTO findAppUserById(UUID id) {
        Optional<AppUser> prosumerOptional = appUserRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("App User with id {} was not found in db", id);
            throw new ResourceNotFoundException(AppUser.class.getSimpleName() + " with id: " + id);
        }
        return AppUserBuilder.toAppUserDTO(prosumerOptional.get());
    }

    public UUID insert(AppUserDTO appUserDTO) {
        AppUser appUser = AppUserBuilder.toEntity(appUserDTO);
        appUser = appUserRepository.save(appUser);
        LOGGER.debug("App User with id {} has been inserted in db", appUser.getId());
        return appUser.getId();
    }

    public UUID delete(UUID id) {
        appUserRepository.deleteAppUserById(id);
        LOGGER.debug("User with id{} has been deleted!", id);
        return id;
    }

    public LoginResponseDTO findMatchingUser(AppUserDTO appUserDTO) {
        String username = appUserDTO.getUsername();
        String password = appUserDTO.getPassword();

        Optional<AppUser> user = appUserRepository.findMatchingUser(username, password);
        if( !user.isPresent() ) {
            throw new ResourceNotFoundException("Username and/or password are incorrect!");
        } else {
            return new LoginResponseDTO(user.get().getId().toString(), user.get().getUsername(), null, user.get().getUserType().toString());
        }

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username);

        if( !user.isPresent() ) {
            throw new UsernameNotFoundException(String.format("User with username: [%s] was not found", username));
        }

        return UserDetailsImpl.build(user.get());

    }
}

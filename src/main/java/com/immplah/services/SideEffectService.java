package com.immplah.services;

import com.immplah.dtos.SideEffectDTO;
import com.immplah.dtos.builders.SideEffectBuilder;
import com.immplah.entities.SideEffect;
import com.immplah.repositories.SideEffectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SideEffectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SideEffectService.class);
    private final SideEffectRepository sideEffectRepository;

    @Autowired
    public SideEffectService(SideEffectRepository sideEffectRepository) {
        this.sideEffectRepository = sideEffectRepository;
    }

    public List<SideEffectDTO> findSideEffects() {
        List<SideEffect> sideEffectList = sideEffectRepository.findAll();
        return sideEffectList.stream()
                .map(SideEffectBuilder::toSideEffectDTO)
                .collect(Collectors.toList());
    }

    public UUID insert(SideEffectDTO sideEffectDTO) {
        SideEffect sideEffect = SideEffectBuilder.toEntity(sideEffectDTO);
        sideEffect = sideEffectRepository.save(sideEffect);
        LOGGER.debug("Side effect with id {} has been inserted into the db", sideEffect.getId());
        return sideEffect.getId();
    }

}

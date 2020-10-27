package com.immplah.dtos;


import org.springframework.hateoas.RepresentationModel;


import java.util.List;
import java.util.UUID;

public class DrugDTO extends RepresentationModel<DrugDTO> {

    private UUID id;
    private String name;
    private String concentrations;
    private List<SideEffectDTO> sideEffects;

    public DrugDTO() {
    }

    public DrugDTO(UUID id, String name, String concentrations, List<SideEffectDTO> sideEffects) {
        this.id = id;
        this.name = name;
        this.concentrations = concentrations;
        this.sideEffects = sideEffects;
    }

    public DrugDTO(UUID id, String name, String concentrations) {
        this.id = id;
        this.name = name;
        this.concentrations = concentrations;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConcentrations() {
        return concentrations;
    }

    public void setConcentrations(String concentrations) {
        this.concentrations = concentrations;
    }

    public List<SideEffectDTO> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(List<SideEffectDTO> sideEffects) {
        this.sideEffects = sideEffects;
    }
}

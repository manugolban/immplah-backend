package com.immplah.dtos;


import java.util.UUID;

public class DrugDTO {

    private UUID id;
    private String name;
    private String concentrations;
    private String sideEffects;

    public DrugDTO() {
    }

    public DrugDTO(UUID id, String name, String concentrations, String sideEffects) {
        this.id = id;
        this.name = name;
        this.concentrations = concentrations;
        this.sideEffects = sideEffects;
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

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }
}

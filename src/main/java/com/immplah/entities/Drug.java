package com.immplah.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Drug implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "concentrations", nullable = false)
    private String concentrations;

    @Column(name = "side_effects", nullable = false)
    private String sideEffects;


    @OneToMany(mappedBy = "drug", cascade = CascadeType.REMOVE)
    private List<PrescribedDrug> prescribedDrugs;

    public Drug() {
    }

    public Drug(String name, String concentrations, String sideEffects, List<PrescribedDrug> prescribedDrugs) {
        this.name = name;
        this.concentrations = concentrations;
        this.sideEffects = sideEffects;
        this.prescribedDrugs = prescribedDrugs;
    }

    public Drug(UUID id, String name, String concentrations, String sideEffects) {
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

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getConcentrations() {
        return concentrations;
    }

    public void setConcentrations(String concentrations) {
        this.concentrations = concentrations;
    }

    public List<PrescribedDrug> getPrescribedDrugs() {
        return prescribedDrugs;
    }

    public void setPrescribedDrugs(List<PrescribedDrug> prescribedDrugs) {
        this.prescribedDrugs = prescribedDrugs;
    }
}

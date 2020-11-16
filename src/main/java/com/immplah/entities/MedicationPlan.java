package com.immplah.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;
import java.util.UUID;

@Entity
public class MedicationPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "period_from", nullable = false)
    private String periodFrom;

    @Column(name = "period_to", nullable = false)
    private String periodTo;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "medicationPlan", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<PrescribedDrug> prescribedDrugs;

    public MedicationPlan() {
    }

    public MedicationPlan(UUID id, String periodFrom, String periodTo, Doctor doctor, Patient patient) {
        this.id = id;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.doctor = doctor;
        this.patient = patient;
    }

    public MedicationPlan(UUID id, String periodFrom, String periodTo) {
        this.id = id;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(String periodTo) {
        this.periodTo = periodTo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<PrescribedDrug> getPrescribedDrugs() {
        return prescribedDrugs;
    }

    public void setPrescribedDrugs(List<PrescribedDrug> prescribedDrugs) {
        this.prescribedDrugs = prescribedDrugs;
    }
}

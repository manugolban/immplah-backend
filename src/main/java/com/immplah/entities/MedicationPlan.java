package com.immplah.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date periodFrom;

    @Column(name = "period_to", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date periodTo;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "medicationPlan")
    private List<PrescribedDrug> prescribedDrugs;

    public MedicationPlan() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(Date periodTo) {
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

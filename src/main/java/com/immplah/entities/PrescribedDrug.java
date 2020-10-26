package com.immplah.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class PrescribedDrug implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="drug_id", nullable = false)
    private Drug drug;

    @ManyToOne
    @JoinColumn(name="medication_plan_id", nullable = false)
    private MedicationPlan medicationPlan;

    @Column(name="morning", nullable = false)
    private boolean morning;
    @Column(name="mid_day", nullable = false)
    private boolean midDay;
    @Column(name="evening", nullable = false)
    private boolean evening;
    @Column(name="bed_time", nullable = false)
    private boolean bedTime;

    @Column(name="dosage", nullable = false)
    private String dosage;

    public PrescribedDrug() {
    }

    public PrescribedDrug(Drug drug, MedicationPlan medicationPlan, boolean morning, boolean midDay, boolean evening, boolean bedTime, String dosage) {
        this.drug = drug;
        this.medicationPlan = medicationPlan;
        this.morning = morning;
        this.midDay = midDay;
        this.evening = evening;
        this.bedTime = bedTime;
        this.dosage = dosage;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public MedicationPlan getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean breakfast) {
        this.morning = breakfast;
    }

    public boolean isMidDay() {
        return midDay;
    }

    public void setMidDay(boolean midDay) {
        this.midDay = midDay;
    }

    public boolean isEvening() {
        return evening;
    }

    public void setEvening(boolean evening) {
        this.evening = evening;
    }

    public boolean isBedTime() {
        return bedTime;
    }

    public void setBedTime(boolean bedTime) {
        this.bedTime = bedTime;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}

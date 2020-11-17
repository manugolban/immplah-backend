package com.immplah.dtos;

import com.immplah.entities.Drug;
import com.immplah.entities.MedicationPlan;
import org.springframework.hateoas.RepresentationModel;


import java.util.UUID;

public class PrescribedDrugDTO  {

    private UUID id;
    private DrugDTO drug;

    private boolean morning;
    private boolean midDay;
    private boolean evening;
    private boolean bedTime;

    private String days;

    private String dosage;


    public PrescribedDrugDTO() {
    }

    public PrescribedDrugDTO(UUID id, DrugDTO drug, boolean morning, boolean midDay, boolean evening, boolean bedTime, String days, String dosage) {
        this.id = id;
        this.drug = drug;
        this.morning = morning;
        this.midDay = midDay;
        this.evening = evening;
        this.bedTime = bedTime;
        this.days = days;
        this.dosage = dosage;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DrugDTO getDrug() {
        return drug;
    }

    public void setDrug(DrugDTO drug) {
        this.drug = drug;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}

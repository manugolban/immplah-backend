package com.immplah.dtos;

import java.io.Serializable;

public class DayPlanDrugDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String drugName;
    private String dosage;

    private boolean morning;
    private boolean midDay;
    private boolean evening;
    private boolean bedTime;

    private boolean taken;

    public DayPlanDrugDTO(String drugName, String dosage) {
        this.drugName = drugName;
        this.dosage = dosage;
    }

    public DayPlanDrugDTO(String drugName, String dosage, boolean morning, boolean midDay, boolean evening, boolean bedTime, boolean taken) {
        this.drugName = drugName;
        this.dosage = dosage;
        this.morning = morning;
        this.midDay = midDay;
        this.evening = evening;
        this.bedTime = bedTime;
        this.taken = taken;
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

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}

package com.immplah.dtos;

import javax.persistence.Column;
import java.util.List;
import java.util.UUID;

public class MedicationPlanDTO {

    private UUID id;

    private String periodFrom;
    private String periodTo;

    private DoctorDTO doctor;
    private PatientDTO patient;

    private List<PrescribedDrugDTO> prescribedDrugs;

    public MedicationPlanDTO(UUID id, String periodFrom, String periodTo, DoctorDTO doctor, PatientDTO patient, List<PrescribedDrugDTO> prescribedDrugs) {
        this.id = id;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.doctor = doctor;
        this.patient = patient;
        this.prescribedDrugs = prescribedDrugs;
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

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public List<PrescribedDrugDTO> getPrescribedDrugs() {
        return prescribedDrugs;
    }

    public void setPrescribedDrugs(List<PrescribedDrugDTO> prescribedDrugs) {
        this.prescribedDrugs = prescribedDrugs;
    }
}

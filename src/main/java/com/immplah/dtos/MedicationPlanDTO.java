package com.immplah.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicationPlanDTO {

    private UUID id;

    private String periodFrom;
    private String periodTo;

    private UUID doctorId;
    private String doctorFullName;
    private UUID patientId;
    private String patientFullName;

    private DoctorDTO doctor;
    private PatientDTO patient;

    private List<PrescribedDrugDTO> prescribedDrugs;

    public MedicationPlanDTO() {
    }

    public MedicationPlanDTO(UUID id, String periodFrom, String periodTo, DoctorDTO doctor, PatientDTO patient, List<PrescribedDrugDTO> prescribedDrugs) {
        this.id = id;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.doctor = doctor;
        this.patient = patient;
        this.prescribedDrugs = prescribedDrugs;
    }

    public MedicationPlanDTO(UUID id, String periodFrom, String periodTo, UUID doctorId, UUID patientId, List<PrescribedDrugDTO> prescribedDrugs) {
        this.id = id;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.prescribedDrugs = prescribedDrugs;
    }

    public MedicationPlanDTO(UUID id, String periodFrom, String periodTo, String doctorFullName, String patientFullName, List<PrescribedDrugDTO> prescribedDrugs) {
        this.id = id;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.doctorFullName = doctorFullName;
        this.patientFullName = patientFullName;
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

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }
}

package com.immplah.dtos;

import com.immplah.entities.AppUser;
import com.immplah.entities.Caregiver;
import com.immplah.entities.MedicationPlan;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.hateoas.RepresentationModel;


import javax.persistence.*;

import java.util.List;
import java.util.UUID;

public class PatientDTO extends RepresentationModel<PatientDTO> {

    private UUID id;

    private String firstName;
    private String lastName;
    private String DOB;

    private String gender;
    private String address;
    private String email;
    private String phone;

    private String medicalRecord;


    private AppUserDTO user;

    private CaregiverDTO caregiver;

    private List<MedicationPlanDTO> medicationPlans;

    public PatientDTO() {
    }

    public PatientDTO(UUID id, String firstName, String lastName, String DOB, String gender, String address, String email, String phone, String medicalRecord, AppUserDTO user, CaregiverDTO caregiver, List<MedicationPlanDTO> medicationPlans) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.medicalRecord = medicalRecord;
        this.user = user;
        this.caregiver = caregiver;
        this.medicationPlans = medicationPlans;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public AppUserDTO getUser() {
        return user;
    }

    public void setUser(AppUserDTO user) {
        this.user = user;
    }

    public CaregiverDTO getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(CaregiverDTO caregiver) {
        this.caregiver = caregiver;
    }

    public List<MedicationPlanDTO> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlanDTO> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }
}

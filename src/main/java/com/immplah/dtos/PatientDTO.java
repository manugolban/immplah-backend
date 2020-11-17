package com.immplah.dtos;

import org.springframework.hateoas.RepresentationModel;


import java.util.List;
import java.util.UUID;

public class PatientDTO  {

    private UUID id;

    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String address;
    private String email;
    private String phone;

    private String medicalRecord;


    //private UUID userId;
    private AppUserDTO user;

    private UUID caregiverId;
    //private CaregiverDTO caregiver;

    private List<MedicationPlanDTO> medicationPlan;

    public PatientDTO() {
    }

    public PatientDTO(UUID id, String firstName, String lastName, String dob, String gender, String address, String email, String phone, String medicalRecord, AppUserDTO user, UUID caregiverId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.medicalRecord = medicalRecord;
        this.user = user;
        this.caregiverId = caregiverId;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public UUID getCaregiverId() {
        return caregiverId;
    }

    public void setCaregiverId(UUID caregiverId) {
        this.caregiverId = caregiverId;
    }

    public AppUserDTO getUser() {
        return user;
    }

    public void setUser(AppUserDTO user) {
        this.user = user;
    }
}

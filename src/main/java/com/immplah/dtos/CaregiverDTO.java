package com.immplah.dtos;

import com.immplah.entities.AppUser;
import com.immplah.entities.Patient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CaregiverDTO  {

    private UUID id;

    private String firstName;
    private String lastName;
    private String DOB;
    private String gender;
    private String address;
    private String email;
    private String phone;

    private AppUserDTO user;
    private List<PatientDTO> patientList;

    public CaregiverDTO() {
    }

    public CaregiverDTO(UUID id, String firstName, String lastName, String DOB, String gender, String address, String email, String phone, AppUserDTO user, List<PatientDTO> patientList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.user = user;
        this.patientList = patientList;
    }

    public CaregiverDTO(UUID id, String firstName, String lastName, String DOB, String gender, String address, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
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

    public AppUserDTO getUser() {
        return user;
    }

    public void setUser(AppUserDTO user) {
        this.user = user;
    }

    public List<PatientDTO> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<PatientDTO> patientList) {
        this.patientList = patientList;
    }
}

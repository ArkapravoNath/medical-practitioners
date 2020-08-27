package com.gok.service.dto;

import java.time.Instant;
import java.io.Serializable;


public class PersonDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String fullName;

    private String gender;

    private String age;

    private Instant dob;

    private String nationality;

    private String citizenShip;

    private String primaryTelephoneNo;

    private String secondayTelephoneNo;

    private String familyHeadName;

    private String familyHeadRelationship;

    private Long familyAdultCount;

    private String guardianName;

    private String status;


    private Long currentAddressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Instant getDob() {
        return dob;
    }

    public void setDob(Instant dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCitizenShip() {
        return citizenShip;
    }

    public void setCitizenShip(String citizenShip) {
        this.citizenShip = citizenShip;
    }

    public String getPrimaryTelephoneNo() {
        return primaryTelephoneNo;
    }

    public void setPrimaryTelephoneNo(String primaryTelephoneNo) {
        this.primaryTelephoneNo = primaryTelephoneNo;
    }

    public String getSecondayTelephoneNo() {
        return secondayTelephoneNo;
    }

    public void setSecondayTelephoneNo(String secondayTelephoneNo) {
        this.secondayTelephoneNo = secondayTelephoneNo;
    }

    public String getFamilyHeadName() {
        return familyHeadName;
    }

    public void setFamilyHeadName(String familyHeadName) {
        this.familyHeadName = familyHeadName;
    }

    public String getFamilyHeadRelationship() {
        return familyHeadRelationship;
    }

    public void setFamilyHeadRelationship(String familyHeadRelationship) {
        this.familyHeadRelationship = familyHeadRelationship;
    }

    public Long getFamilyAdultCount() {
        return familyAdultCount;
    }

    public void setFamilyAdultCount(Long familyAdultCount) {
        this.familyAdultCount = familyAdultCount;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCurrentAddressId() {
        return currentAddressId;
    }

    public void setCurrentAddressId(Long addressId) {
        this.currentAddressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonDTO)) {
            return false;
        }

        return id != null && id.equals(((PersonDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PersonDTO{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", middleName='" + getMiddleName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", gender='" + getGender() + "'" +
            ", age='" + getAge() + "'" +
            ", dob='" + getDob() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", citizenShip='" + getCitizenShip() + "'" +
            ", primaryTelephoneNo='" + getPrimaryTelephoneNo() + "'" +
            ", secondayTelephoneNo='" + getSecondayTelephoneNo() + "'" +
            ", familyHeadName='" + getFamilyHeadName() + "'" +
            ", familyHeadRelationship='" + getFamilyHeadRelationship() + "'" +
            ", familyAdultCount=" + getFamilyAdultCount() +
            ", guardianName='" + getGuardianName() + "'" +
            ", status='" + getStatus() + "'" +
            ", currentAddressId=" + getCurrentAddressId() +
            "}";
    }
}

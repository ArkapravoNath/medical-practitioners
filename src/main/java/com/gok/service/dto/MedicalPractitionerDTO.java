package com.gok.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.gok.domain.MedicalPractitioner} entity.
 */
public class MedicalPractitionerDTO extends AbstractAuditingDTO implements Serializable {
    
    private Long id;

    private String practitionerType;

    private String specialty;

    private String registrationNumber;

    private String employmentMode;

    private String qualification;

    private String status;

    private Long personIdRef;


    private Long sourceDataIdentityId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPractitionerType() {
        return practitionerType;
    }

    public void setPractitionerType(String practitionerType) {
        this.practitionerType = practitionerType;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmploymentMode() {
        return employmentMode;
    }

    public void setEmploymentMode(String employmentMode) {
        this.employmentMode = employmentMode;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPersonIdRef() {
        return personIdRef;
    }

    public void setPersonIdRef(Long personIdRef) {
        this.personIdRef = personIdRef;
    }

    public Long getSourceDataIdentityId() {
        return sourceDataIdentityId;
    }

    public void setSourceDataIdentityId(Long sourceDataIdentityId) {
        this.sourceDataIdentityId = sourceDataIdentityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicalPractitionerDTO)) {
            return false;
        }

        return id != null && id.equals(((MedicalPractitionerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MedicalPractitionerDTO{" +
            "id=" + getId() +
            ", practitionerType='" + getPractitionerType() + "'" +
            ", specialty='" + getSpecialty() + "'" +
            ", registrationNumber='" + getRegistrationNumber() + "'" +
            ", employmentMode='" + getEmploymentMode() + "'" +
            ", qualification='" + getQualification() + "'" +
            ", status='" + getStatus() + "'" +
            ", personIdRef=" + getPersonIdRef() +
            ", sourceDataIdentityId=" + getSourceDataIdentityId() +
            "}";
    }
}

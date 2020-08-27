package com.gok.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.gok.domain.Document} entity.
 */
public class DocumentDTO extends AbstractAuditingDTO implements Serializable {
    
    private Long id;

    private String idType;

    private String idNumber;

    private String status;


    private Long medicalPractitionerId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMedicalPractitionerId() {
        return medicalPractitionerId;
    }

    public void setMedicalPractitionerId(Long medicalPractitionerId) {
        this.medicalPractitionerId = medicalPractitionerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DocumentDTO)) {
            return false;
        }

        return id != null && id.equals(((DocumentDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DocumentDTO{" +
            "id=" + getId() +
            ", idType='" + getIdType() + "'" +
            ", idNumber='" + getIdNumber() + "'" +
            ", status='" + getStatus() + "'" +
            ", medicalPractitionerId=" + getMedicalPractitionerId() +
            "}";
    }
}

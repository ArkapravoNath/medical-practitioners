package com.gok.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.gok.domain.SourceDataIdentity} entity.
 */
public class SourceDataIdentityDTO extends AbstractAuditingDTO implements Serializable {
    
    private Long id;

    private String serviceProviderName;

    private String entityName;

    private String sourceRecordId;

    private String dataCapturedElements;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getSourceRecordId() {
        return sourceRecordId;
    }

    public void setSourceRecordId(String sourceRecordId) {
        this.sourceRecordId = sourceRecordId;
    }

    public String getDataCapturedElements() {
        return dataCapturedElements;
    }

    public void setDataCapturedElements(String dataCapturedElements) {
        this.dataCapturedElements = dataCapturedElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SourceDataIdentityDTO)) {
            return false;
        }

        return id != null && id.equals(((SourceDataIdentityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SourceDataIdentityDTO{" +
            "id=" + getId() +
            ", serviceProviderName='" + getServiceProviderName() + "'" +
            ", entityName='" + getEntityName() + "'" +
            ", sourceRecordId='" + getSourceRecordId() + "'" +
            ", dataCapturedElements='" + getDataCapturedElements() + "'" +
            "}";
    }
}

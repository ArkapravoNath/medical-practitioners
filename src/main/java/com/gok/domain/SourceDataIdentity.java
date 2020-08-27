package com.gok.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A SourceDataIdentity.
 */
@Entity
@Table(name = "source_data_identity")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SourceDataIdentity extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "service_provider_name")
    private String serviceProviderName;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "source_record_id")
    private String sourceRecordId;

    @Column(name = "data_captured_elements")
    private String dataCapturedElements;

    @OneToOne(mappedBy = "sourceDataIdentity")
    @JsonIgnore
    private MedicalPractitioner medicalPractitioner;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public SourceDataIdentity serviceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
        return this;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public String getEntityName() {
        return entityName;
    }

    public SourceDataIdentity entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getSourceRecordId() {
        return sourceRecordId;
    }

    public SourceDataIdentity sourceRecordId(String sourceRecordId) {
        this.sourceRecordId = sourceRecordId;
        return this;
    }

    public void setSourceRecordId(String sourceRecordId) {
        this.sourceRecordId = sourceRecordId;
    }

    public String getDataCapturedElements() {
        return dataCapturedElements;
    }

    public SourceDataIdentity dataCapturedElements(String dataCapturedElements) {
        this.dataCapturedElements = dataCapturedElements;
        return this;
    }

    public void setDataCapturedElements(String dataCapturedElements) {
        this.dataCapturedElements = dataCapturedElements;
    }

    public MedicalPractitioner getMedicalPractitioner() {
        return medicalPractitioner;
    }

    public SourceDataIdentity medicalPractitioner(MedicalPractitioner medicalPractitioner) {
        this.medicalPractitioner = medicalPractitioner;
        return this;
    }

    public void setMedicalPractitioner(MedicalPractitioner medicalPractitioner) {
        this.medicalPractitioner = medicalPractitioner;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SourceDataIdentity)) {
            return false;
        }
        return id != null && id.equals(((SourceDataIdentity) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SourceDataIdentity{" +
            "id=" + getId() +
            ", serviceProviderName='" + getServiceProviderName() + "'" +
            ", entityName='" + getEntityName() + "'" +
            ", sourceRecordId='" + getSourceRecordId() + "'" +
            ", dataCapturedElements='" + getDataCapturedElements() + "'" +
            "}";
    }
}

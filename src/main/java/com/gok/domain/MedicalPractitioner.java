package com.gok.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A MedicalPractitioner.
 */
@Entity
@Table(name = "medical_practitioner")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MedicalPractitioner extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "practitioner_type")
    private String practitionerType;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "employment_mode")
    private String employmentMode;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "status")
    private String status;

    @Column(name = "person_id_ref")
    private Long personIdRef;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true, name = "sourceDataIdentityId")
    private SourceDataIdentity sourceDataIdentity;

    @OneToMany(mappedBy = "medicalPractitioner", cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Document> documents = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPractitionerType() {
        return practitionerType;
    }

    public MedicalPractitioner practitionerType(String practitionerType) {
        this.practitionerType = practitionerType;
        return this;
    }

    public void setPractitionerType(String practitionerType) {
        this.practitionerType = practitionerType;
    }

    public String getSpecialty() {
        return specialty;
    }

    public MedicalPractitioner specialty(String specialty) {
        this.specialty = specialty;
        return this;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public MedicalPractitioner registrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmploymentMode() {
        return employmentMode;
    }

    public MedicalPractitioner employmentMode(String employmentMode) {
        this.employmentMode = employmentMode;
        return this;
    }

    public void setEmploymentMode(String employmentMode) {
        this.employmentMode = employmentMode;
    }

    public String getQualification() {
        return qualification;
    }

    public MedicalPractitioner qualification(String qualification) {
        this.qualification = qualification;
        return this;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStatus() {
        return status;
    }

    public MedicalPractitioner status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPersonIdRef() {
        return personIdRef;
    }

    public MedicalPractitioner personIdRef(Long personIdRef) {
        this.personIdRef = personIdRef;
        return this;
    }

    public void setPersonIdRef(Long personIdRef) {
        this.personIdRef = personIdRef;
    }

    public SourceDataIdentity getSourceDataIdentity() {
        return sourceDataIdentity;
    }

    public MedicalPractitioner sourceDataIdentity(SourceDataIdentity sourceDataIdentity) {
        this.sourceDataIdentity = sourceDataIdentity;
        return this;
    }

    public void setSourceDataIdentity(SourceDataIdentity sourceDataIdentity) {
        this.sourceDataIdentity = sourceDataIdentity;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public MedicalPractitioner documents(Set<Document> documents) {
        this.documents = documents;
        return this;
    }

    public MedicalPractitioner addDocument(Document document) {
        this.documents.add(document);
        document.setMedicalPractitioner(this);
        return this;
    }

    public MedicalPractitioner removeDocument(Document document) {
        this.documents.remove(document);
        document.setMedicalPractitioner(null);
        return this;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicalPractitioner)) {
            return false;
        }
        return id != null && id.equals(((MedicalPractitioner) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MedicalPractitioner{" +
            "id=" + getId() +
            ", practitionerType='" + getPractitionerType() + "'" +
            ", specialty='" + getSpecialty() + "'" +
            ", registrationNumber='" + getRegistrationNumber() + "'" +
            ", employmentMode='" + getEmploymentMode() + "'" +
            ", qualification='" + getQualification() + "'" +
            ", status='" + getStatus() + "'" +
            ", personIdRef=" + getPersonIdRef() +
            "}";
    }
}

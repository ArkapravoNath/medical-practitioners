package com.gok.service;

import com.gok.service.dto.SourceDataIdentityDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.gok.domain.SourceDataIdentity}.
 */
public interface SourceDataIdentityService {

    /**
     * Save a sourceDataIdentity.
     *
     * @param sourceDataIdentityDTO the entity to save.
     * @return the persisted entity.
     */
    SourceDataIdentityDTO save(SourceDataIdentityDTO sourceDataIdentityDTO);

    /**
     * Get all the sourceDataIdentities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SourceDataIdentityDTO> findAll(Pageable pageable);
    /**
     * Get all the SourceDataIdentityDTO where MedicalPractitioner is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<SourceDataIdentityDTO> findAllWhereMedicalPractitionerIsNull();


    /**
     * Get the "id" sourceDataIdentity.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SourceDataIdentityDTO> findOne(Long id);

    /**
     * Delete the "id" sourceDataIdentity.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

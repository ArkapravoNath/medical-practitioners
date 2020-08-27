package com.gok.web.rest;

import com.gok.service.SourceDataIdentityService;
import com.gok.web.rest.errors.BadRequestAlertException;
import com.gok.service.dto.SourceDataIdentityDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing {@link com.gok.domain.SourceDataIdentity}.
 */
@RestController
@RequestMapping("/api")
public class SourceDataIdentityResource {

    private final Logger log = LoggerFactory.getLogger(SourceDataIdentityResource.class);

    private static final String ENTITY_NAME = "medicalpractitionerSourceDataIdentity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SourceDataIdentityService sourceDataIdentityService;

    public SourceDataIdentityResource(SourceDataIdentityService sourceDataIdentityService) {
        this.sourceDataIdentityService = sourceDataIdentityService;
    }

    /**
     * {@code POST  /source-data-identities} : Create a new sourceDataIdentity.
     *
     * @param sourceDataIdentityDTO the sourceDataIdentityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sourceDataIdentityDTO, or with status {@code 400 (Bad Request)} if the sourceDataIdentity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/source-data-identities")
    public ResponseEntity<SourceDataIdentityDTO> createSourceDataIdentity(@RequestBody SourceDataIdentityDTO sourceDataIdentityDTO) throws URISyntaxException {
        log.debug("REST request to save SourceDataIdentity : {}", sourceDataIdentityDTO);
        if (sourceDataIdentityDTO.getId() != null) {
            throw new BadRequestAlertException("A new sourceDataIdentity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SourceDataIdentityDTO result = sourceDataIdentityService.save(sourceDataIdentityDTO);
        return ResponseEntity.created(new URI("/api/source-data-identities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /source-data-identities} : Updates an existing sourceDataIdentity.
     *
     * @param sourceDataIdentityDTO the sourceDataIdentityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sourceDataIdentityDTO,
     * or with status {@code 400 (Bad Request)} if the sourceDataIdentityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sourceDataIdentityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/source-data-identities")
    public ResponseEntity<SourceDataIdentityDTO> updateSourceDataIdentity(@RequestBody SourceDataIdentityDTO sourceDataIdentityDTO) throws URISyntaxException {
        log.debug("REST request to update SourceDataIdentity : {}", sourceDataIdentityDTO);
        if (sourceDataIdentityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SourceDataIdentityDTO result = sourceDataIdentityService.save(sourceDataIdentityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, sourceDataIdentityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /source-data-identities} : get all the sourceDataIdentities.
     *
     * @param pageable the pagination information.
     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sourceDataIdentities in body.
     */
    @GetMapping("/source-data-identities")
    public ResponseEntity<List<SourceDataIdentityDTO>> getAllSourceDataIdentities(Pageable pageable, @RequestParam(required = false) String filter) {
        if ("medicalpractitioner-is-null".equals(filter)) {
            log.debug("REST request to get all SourceDataIdentitys where medicalPractitioner is null");
            return new ResponseEntity<>(sourceDataIdentityService.findAllWhereMedicalPractitionerIsNull(),
                    HttpStatus.OK);
        }
        log.debug("REST request to get a page of SourceDataIdentities");
        Page<SourceDataIdentityDTO> page = sourceDataIdentityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /source-data-identities/:id} : get the "id" sourceDataIdentity.
     *
     * @param id the id of the sourceDataIdentityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sourceDataIdentityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/source-data-identities/{id}")
    public ResponseEntity<SourceDataIdentityDTO> getSourceDataIdentity(@PathVariable Long id) {
        log.debug("REST request to get SourceDataIdentity : {}", id);
        Optional<SourceDataIdentityDTO> sourceDataIdentityDTO = sourceDataIdentityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sourceDataIdentityDTO);
    }

    /**
     * {@code DELETE  /source-data-identities/:id} : delete the "id" sourceDataIdentity.
     *
     * @param id the id of the sourceDataIdentityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/source-data-identities/{id}")
    public ResponseEntity<Void> deleteSourceDataIdentity(@PathVariable Long id) {
        log.debug("REST request to delete SourceDataIdentity : {}", id);
        sourceDataIdentityService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

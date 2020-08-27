package com.gok.web.rest;

import com.gok.MedicalpractitionerApp;
import com.gok.config.TestSecurityConfiguration;
import com.gok.domain.SourceDataIdentity;
import com.gok.repository.SourceDataIdentityRepository;
import com.gok.service.SourceDataIdentityService;
import com.gok.service.dto.SourceDataIdentityDTO;
import com.gok.service.mapper.SourceDataIdentityMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link SourceDataIdentityResource} REST controller.
 */
@SpringBootTest(classes = { MedicalpractitionerApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class SourceDataIdentityResourceIT {

    private static final String DEFAULT_SERVICE_PROVIDER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_PROVIDER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_RECORD_ID = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_RECORD_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_CAPTURED_ELEMENTS = "AAAAAAAAAA";
    private static final String UPDATED_DATA_CAPTURED_ELEMENTS = "BBBBBBBBBB";

    @Autowired
    private SourceDataIdentityRepository sourceDataIdentityRepository;

    @Autowired
    private SourceDataIdentityMapper sourceDataIdentityMapper;

    @Autowired
    private SourceDataIdentityService sourceDataIdentityService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSourceDataIdentityMockMvc;

    private SourceDataIdentity sourceDataIdentity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SourceDataIdentity createEntity(EntityManager em) {
        SourceDataIdentity sourceDataIdentity = new SourceDataIdentity()
            .serviceProviderName(DEFAULT_SERVICE_PROVIDER_NAME)
            .entityName(DEFAULT_ENTITY_NAME)
            .sourceRecordId(DEFAULT_SOURCE_RECORD_ID)
            .dataCapturedElements(DEFAULT_DATA_CAPTURED_ELEMENTS);
        return sourceDataIdentity;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SourceDataIdentity createUpdatedEntity(EntityManager em) {
        SourceDataIdentity sourceDataIdentity = new SourceDataIdentity()
            .serviceProviderName(UPDATED_SERVICE_PROVIDER_NAME)
            .entityName(UPDATED_ENTITY_NAME)
            .sourceRecordId(UPDATED_SOURCE_RECORD_ID)
            .dataCapturedElements(UPDATED_DATA_CAPTURED_ELEMENTS);
        return sourceDataIdentity;
    }

    @BeforeEach
    public void initTest() {
        sourceDataIdentity = createEntity(em);
    }

    @Test
    @Transactional
    public void createSourceDataIdentity() throws Exception {
        int databaseSizeBeforeCreate = sourceDataIdentityRepository.findAll().size();
        // Create the SourceDataIdentity
        SourceDataIdentityDTO sourceDataIdentityDTO = sourceDataIdentityMapper.toDto(sourceDataIdentity);
        restSourceDataIdentityMockMvc.perform(post("/api/source-data-identities").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sourceDataIdentityDTO)))
            .andExpect(status().isCreated());

        // Validate the SourceDataIdentity in the database
        List<SourceDataIdentity> sourceDataIdentityList = sourceDataIdentityRepository.findAll();
        assertThat(sourceDataIdentityList).hasSize(databaseSizeBeforeCreate + 1);
        SourceDataIdentity testSourceDataIdentity = sourceDataIdentityList.get(sourceDataIdentityList.size() - 1);
        assertThat(testSourceDataIdentity.getServiceProviderName()).isEqualTo(DEFAULT_SERVICE_PROVIDER_NAME);
        assertThat(testSourceDataIdentity.getEntityName()).isEqualTo(DEFAULT_ENTITY_NAME);
        assertThat(testSourceDataIdentity.getSourceRecordId()).isEqualTo(DEFAULT_SOURCE_RECORD_ID);
        assertThat(testSourceDataIdentity.getDataCapturedElements()).isEqualTo(DEFAULT_DATA_CAPTURED_ELEMENTS);
    }

    @Test
    @Transactional
    public void createSourceDataIdentityWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sourceDataIdentityRepository.findAll().size();

        // Create the SourceDataIdentity with an existing ID
        sourceDataIdentity.setId(1L);
        SourceDataIdentityDTO sourceDataIdentityDTO = sourceDataIdentityMapper.toDto(sourceDataIdentity);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSourceDataIdentityMockMvc.perform(post("/api/source-data-identities").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sourceDataIdentityDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SourceDataIdentity in the database
        List<SourceDataIdentity> sourceDataIdentityList = sourceDataIdentityRepository.findAll();
        assertThat(sourceDataIdentityList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSourceDataIdentities() throws Exception {
        // Initialize the database
        sourceDataIdentityRepository.saveAndFlush(sourceDataIdentity);

        // Get all the sourceDataIdentityList
        restSourceDataIdentityMockMvc.perform(get("/api/source-data-identities?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sourceDataIdentity.getId().intValue())))
            .andExpect(jsonPath("$.[*].serviceProviderName").value(hasItem(DEFAULT_SERVICE_PROVIDER_NAME)))
            .andExpect(jsonPath("$.[*].entityName").value(hasItem(DEFAULT_ENTITY_NAME)))
            .andExpect(jsonPath("$.[*].sourceRecordId").value(hasItem(DEFAULT_SOURCE_RECORD_ID)))
            .andExpect(jsonPath("$.[*].dataCapturedElements").value(hasItem(DEFAULT_DATA_CAPTURED_ELEMENTS)));
    }
    
    @Test
    @Transactional
    public void getSourceDataIdentity() throws Exception {
        // Initialize the database
        sourceDataIdentityRepository.saveAndFlush(sourceDataIdentity);

        // Get the sourceDataIdentity
        restSourceDataIdentityMockMvc.perform(get("/api/source-data-identities/{id}", sourceDataIdentity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sourceDataIdentity.getId().intValue()))
            .andExpect(jsonPath("$.serviceProviderName").value(DEFAULT_SERVICE_PROVIDER_NAME))
            .andExpect(jsonPath("$.entityName").value(DEFAULT_ENTITY_NAME))
            .andExpect(jsonPath("$.sourceRecordId").value(DEFAULT_SOURCE_RECORD_ID))
            .andExpect(jsonPath("$.dataCapturedElements").value(DEFAULT_DATA_CAPTURED_ELEMENTS));
    }
    @Test
    @Transactional
    public void getNonExistingSourceDataIdentity() throws Exception {
        // Get the sourceDataIdentity
        restSourceDataIdentityMockMvc.perform(get("/api/source-data-identities/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSourceDataIdentity() throws Exception {
        // Initialize the database
        sourceDataIdentityRepository.saveAndFlush(sourceDataIdentity);

        int databaseSizeBeforeUpdate = sourceDataIdentityRepository.findAll().size();

        // Update the sourceDataIdentity
        SourceDataIdentity updatedSourceDataIdentity = sourceDataIdentityRepository.findById(sourceDataIdentity.getId()).get();
        // Disconnect from session so that the updates on updatedSourceDataIdentity are not directly saved in db
        em.detach(updatedSourceDataIdentity);
        updatedSourceDataIdentity
            .serviceProviderName(UPDATED_SERVICE_PROVIDER_NAME)
            .entityName(UPDATED_ENTITY_NAME)
            .sourceRecordId(UPDATED_SOURCE_RECORD_ID)
            .dataCapturedElements(UPDATED_DATA_CAPTURED_ELEMENTS);
        SourceDataIdentityDTO sourceDataIdentityDTO = sourceDataIdentityMapper.toDto(updatedSourceDataIdentity);

        restSourceDataIdentityMockMvc.perform(put("/api/source-data-identities").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sourceDataIdentityDTO)))
            .andExpect(status().isOk());

        // Validate the SourceDataIdentity in the database
        List<SourceDataIdentity> sourceDataIdentityList = sourceDataIdentityRepository.findAll();
        assertThat(sourceDataIdentityList).hasSize(databaseSizeBeforeUpdate);
        SourceDataIdentity testSourceDataIdentity = sourceDataIdentityList.get(sourceDataIdentityList.size() - 1);
        assertThat(testSourceDataIdentity.getServiceProviderName()).isEqualTo(UPDATED_SERVICE_PROVIDER_NAME);
        assertThat(testSourceDataIdentity.getEntityName()).isEqualTo(UPDATED_ENTITY_NAME);
        assertThat(testSourceDataIdentity.getSourceRecordId()).isEqualTo(UPDATED_SOURCE_RECORD_ID);
        assertThat(testSourceDataIdentity.getDataCapturedElements()).isEqualTo(UPDATED_DATA_CAPTURED_ELEMENTS);
    }

    @Test
    @Transactional
    public void updateNonExistingSourceDataIdentity() throws Exception {
        int databaseSizeBeforeUpdate = sourceDataIdentityRepository.findAll().size();

        // Create the SourceDataIdentity
        SourceDataIdentityDTO sourceDataIdentityDTO = sourceDataIdentityMapper.toDto(sourceDataIdentity);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSourceDataIdentityMockMvc.perform(put("/api/source-data-identities").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sourceDataIdentityDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SourceDataIdentity in the database
        List<SourceDataIdentity> sourceDataIdentityList = sourceDataIdentityRepository.findAll();
        assertThat(sourceDataIdentityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSourceDataIdentity() throws Exception {
        // Initialize the database
        sourceDataIdentityRepository.saveAndFlush(sourceDataIdentity);

        int databaseSizeBeforeDelete = sourceDataIdentityRepository.findAll().size();

        // Delete the sourceDataIdentity
        restSourceDataIdentityMockMvc.perform(delete("/api/source-data-identities/{id}", sourceDataIdentity.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SourceDataIdentity> sourceDataIdentityList = sourceDataIdentityRepository.findAll();
        assertThat(sourceDataIdentityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

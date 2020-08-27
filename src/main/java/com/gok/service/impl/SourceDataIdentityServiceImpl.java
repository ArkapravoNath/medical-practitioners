package com.gok.service.impl;

import com.gok.service.SourceDataIdentityService;
import com.gok.domain.SourceDataIdentity;
import com.gok.repository.SourceDataIdentityRepository;
import com.gok.service.dto.SourceDataIdentityDTO;
import com.gok.service.mapper.SourceDataIdentityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link SourceDataIdentity}.
 */
@Service
@Transactional
public class SourceDataIdentityServiceImpl implements SourceDataIdentityService {

    private final Logger log = LoggerFactory.getLogger(SourceDataIdentityServiceImpl.class);

    private final SourceDataIdentityRepository sourceDataIdentityRepository;

    private final SourceDataIdentityMapper sourceDataIdentityMapper;

    public SourceDataIdentityServiceImpl(SourceDataIdentityRepository sourceDataIdentityRepository, SourceDataIdentityMapper sourceDataIdentityMapper) {
        this.sourceDataIdentityRepository = sourceDataIdentityRepository;
        this.sourceDataIdentityMapper = sourceDataIdentityMapper;
    }

    @Override
    public SourceDataIdentityDTO save(SourceDataIdentityDTO sourceDataIdentityDTO) {
        log.debug("Request to save SourceDataIdentity : {}", sourceDataIdentityDTO);
        SourceDataIdentity sourceDataIdentity = sourceDataIdentityMapper.toEntity(sourceDataIdentityDTO);
        sourceDataIdentity = sourceDataIdentityRepository.save(sourceDataIdentity);
        return sourceDataIdentityMapper.toDto(sourceDataIdentity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SourceDataIdentityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SourceDataIdentities");
        return sourceDataIdentityRepository.findAll(pageable)
            .map(sourceDataIdentityMapper::toDto);
    }



    /**
     *  Get all the sourceDataIdentities where MedicalPractitioner is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<SourceDataIdentityDTO> findAllWhereMedicalPractitionerIsNull() {
        log.debug("Request to get all sourceDataIdentities where MedicalPractitioner is null");
        return StreamSupport
            .stream(sourceDataIdentityRepository.findAll().spliterator(), false)
            .filter(sourceDataIdentity -> sourceDataIdentity.getMedicalPractitioner() == null)
            .map(sourceDataIdentityMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SourceDataIdentityDTO> findOne(Long id) {
        log.debug("Request to get SourceDataIdentity : {}", id);
        return sourceDataIdentityRepository.findById(id)
            .map(sourceDataIdentityMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SourceDataIdentity : {}", id);
        sourceDataIdentityRepository.deleteById(id);
    }
}

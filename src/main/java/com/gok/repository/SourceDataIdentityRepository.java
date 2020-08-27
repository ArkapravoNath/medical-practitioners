package com.gok.repository;

import com.gok.domain.SourceDataIdentity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SourceDataIdentity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SourceDataIdentityRepository extends JpaRepository<SourceDataIdentity, Long> {
}

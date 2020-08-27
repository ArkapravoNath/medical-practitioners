package com.gok.service.mapper;


import com.gok.domain.*;
import com.gok.service.dto.SourceDataIdentityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SourceDataIdentity} and its DTO {@link SourceDataIdentityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SourceDataIdentityMapper extends EntityMapper<SourceDataIdentityDTO, SourceDataIdentity> {


    @Mapping(target = "medicalPractitioner", ignore = true)
    SourceDataIdentity toEntity(SourceDataIdentityDTO sourceDataIdentityDTO);

    default SourceDataIdentity fromId(Long id) {
        if (id == null) {
            return null;
        }
        SourceDataIdentity sourceDataIdentity = new SourceDataIdentity();
        sourceDataIdentity.setId(id);
        return sourceDataIdentity;
    }
}

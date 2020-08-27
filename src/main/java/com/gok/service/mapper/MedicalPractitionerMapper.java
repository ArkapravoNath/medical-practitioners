package com.gok.service.mapper;


import com.gok.domain.*;
import com.gok.service.dto.MedicalPractitionerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MedicalPractitioner} and its DTO {@link MedicalPractitionerDTO}.
 */
@Mapper(componentModel = "spring", uses = {SourceDataIdentityMapper.class})
public interface MedicalPractitionerMapper extends EntityMapper<MedicalPractitionerDTO, MedicalPractitioner> {

    @Mapping(source = "sourceDataIdentity.id", target = "sourceDataIdentityId")
    MedicalPractitionerDTO toDto(MedicalPractitioner medicalPractitioner);

    @Mapping(source = "sourceDataIdentityId", target = "sourceDataIdentity")
    @Mapping(target = "documents", ignore = true)
    @Mapping(target = "removeDocument", ignore = true)
    MedicalPractitioner toEntity(MedicalPractitionerDTO medicalPractitionerDTO);

    default MedicalPractitioner fromId(Long id) {
        if (id == null) {
            return null;
        }
        MedicalPractitioner medicalPractitioner = new MedicalPractitioner();
        medicalPractitioner.setId(id);
        return medicalPractitioner;
    }
}

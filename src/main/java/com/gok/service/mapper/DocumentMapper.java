package com.gok.service.mapper;


import com.gok.domain.*;
import com.gok.service.dto.DocumentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Document} and its DTO {@link DocumentDTO}.
 */
@Mapper(componentModel = "spring", uses = {MedicalPractitionerMapper.class})
public interface DocumentMapper extends EntityMapper<DocumentDTO, Document> {

    @Mapping(source = "medicalPractitioner.id", target = "medicalPractitionerId")
    DocumentDTO toDto(Document document);

    @Mapping(source = "medicalPractitionerId", target = "medicalPractitioner")
    Document toEntity(DocumentDTO documentDTO);

    default Document fromId(Long id) {
        if (id == null) {
            return null;
        }
        Document document = new Document();
        document.setId(id);
        return document;
    }
}

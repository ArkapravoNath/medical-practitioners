package com.gok.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SourceDataIdentityMapperTest {

    private SourceDataIdentityMapper sourceDataIdentityMapper;

    @BeforeEach
    public void setUp() {
        sourceDataIdentityMapper = new SourceDataIdentityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(sourceDataIdentityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(sourceDataIdentityMapper.fromId(null)).isNull();
    }
}

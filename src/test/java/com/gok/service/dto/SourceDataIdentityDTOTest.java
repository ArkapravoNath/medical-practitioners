package com.gok.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.gok.web.rest.TestUtil;

public class SourceDataIdentityDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SourceDataIdentityDTO.class);
        SourceDataIdentityDTO sourceDataIdentityDTO1 = new SourceDataIdentityDTO();
        sourceDataIdentityDTO1.setId(1L);
        SourceDataIdentityDTO sourceDataIdentityDTO2 = new SourceDataIdentityDTO();
        assertThat(sourceDataIdentityDTO1).isNotEqualTo(sourceDataIdentityDTO2);
        sourceDataIdentityDTO2.setId(sourceDataIdentityDTO1.getId());
        assertThat(sourceDataIdentityDTO1).isEqualTo(sourceDataIdentityDTO2);
        sourceDataIdentityDTO2.setId(2L);
        assertThat(sourceDataIdentityDTO1).isNotEqualTo(sourceDataIdentityDTO2);
        sourceDataIdentityDTO1.setId(null);
        assertThat(sourceDataIdentityDTO1).isNotEqualTo(sourceDataIdentityDTO2);
    }
}

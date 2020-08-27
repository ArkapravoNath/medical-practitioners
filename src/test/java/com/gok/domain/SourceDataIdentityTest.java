package com.gok.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.gok.web.rest.TestUtil;

public class SourceDataIdentityTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SourceDataIdentity.class);
        SourceDataIdentity sourceDataIdentity1 = new SourceDataIdentity();
        sourceDataIdentity1.setId(1L);
        SourceDataIdentity sourceDataIdentity2 = new SourceDataIdentity();
        sourceDataIdentity2.setId(sourceDataIdentity1.getId());
        assertThat(sourceDataIdentity1).isEqualTo(sourceDataIdentity2);
        sourceDataIdentity2.setId(2L);
        assertThat(sourceDataIdentity1).isNotEqualTo(sourceDataIdentity2);
        sourceDataIdentity1.setId(null);
        assertThat(sourceDataIdentity1).isNotEqualTo(sourceDataIdentity2);
    }
}

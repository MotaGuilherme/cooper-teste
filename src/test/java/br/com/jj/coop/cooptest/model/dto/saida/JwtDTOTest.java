package br.com.jj.coop.cooptest.model.dto.saida;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JwtDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        JwtDTO jwtDTO1 = new JwtDTO("TOKEN1");
        JwtDTO jwtDTO2 = new JwtDTO("TOKEN2");
        assertThat(jwtDTO1).isNotEqualTo(jwtDTO2);
        jwtDTO2.setToken(jwtDTO1.getToken());
        assertThat(jwtDTO1).isEqualTo(jwtDTO2);
        jwtDTO2.setToken("TOKEN3");
        assertThat(jwtDTO1).isNotEqualTo(jwtDTO2);
        jwtDTO1.setToken(null);
        assertThat(jwtDTO1).isNotEqualTo(jwtDTO2);
    }
}

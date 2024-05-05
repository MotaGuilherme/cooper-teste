package br.com.jj.coop.cooptest.model.dto.entrada;

import br.com.jj.coop.cooptest.util.CoopTestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CadastroTelefoneDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        CoopTestUtil.equalsVerifier(CadastroTelefoneDTO.class);
        CadastroTelefoneDTO cadastroTelefoneDTO1 = new CadastroTelefoneDTO();
        cadastroTelefoneDTO1.setId(1L);
        CadastroTelefoneDTO cadastroTelefoneDTO2 = new CadastroTelefoneDTO();
        assertThat(cadastroTelefoneDTO1).isNotEqualTo(cadastroTelefoneDTO2);
        cadastroTelefoneDTO2.setId(cadastroTelefoneDTO1.getId());
        assertThat(cadastroTelefoneDTO1).isEqualTo(cadastroTelefoneDTO2);
        cadastroTelefoneDTO2.setId(2L);
        assertThat(cadastroTelefoneDTO1).isNotEqualTo(cadastroTelefoneDTO2);
        cadastroTelefoneDTO1.setId(null);
        assertThat(cadastroTelefoneDTO1).isNotEqualTo(cadastroTelefoneDTO2);
    }
}

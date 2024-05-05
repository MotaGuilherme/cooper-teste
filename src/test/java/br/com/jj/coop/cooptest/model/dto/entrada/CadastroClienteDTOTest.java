package br.com.jj.coop.cooptest.model.dto.entrada;

import br.com.jj.coop.cooptest.util.CoopTestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CadastroClienteDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        CoopTestUtil.equalsVerifier(CadastroClienteDTO.class);
        CadastroClienteDTO cadastroClienteDTO1 = new CadastroClienteDTO();
        cadastroClienteDTO1.setId(1L);
        CadastroClienteDTO cadastroClienteDTO2 = new CadastroClienteDTO();
        assertThat(cadastroClienteDTO1).isNotEqualTo(cadastroClienteDTO2);
        cadastroClienteDTO2.setId(cadastroClienteDTO1.getId());
        assertThat(cadastroClienteDTO1).isEqualTo(cadastroClienteDTO2);
        cadastroClienteDTO2.setId(2L);
        assertThat(cadastroClienteDTO1).isNotEqualTo(cadastroClienteDTO2);
        cadastroClienteDTO1.setId(null);
        assertThat(cadastroClienteDTO1).isNotEqualTo(cadastroClienteDTO2);
    }
}

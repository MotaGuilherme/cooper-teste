package br.com.jj.coop.cooptest.model.dto.entrada;

import br.com.jj.coop.cooptest.util.CoopTestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CadastroEmailDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        CoopTestUtil.equalsVerifier(CadastroEmailDTO.class);
        CadastroEmailDTO cadastroEmailDTO1 = new CadastroEmailDTO();
        cadastroEmailDTO1.setId(1L);
        CadastroEmailDTO emailDTO2 = new CadastroEmailDTO();
        assertThat(cadastroEmailDTO1).isNotEqualTo(emailDTO2);
        emailDTO2.setId(cadastroEmailDTO1.getId());
        assertThat(cadastroEmailDTO1).isEqualTo(emailDTO2);
        emailDTO2.setId(2L);
        assertThat(cadastroEmailDTO1).isNotEqualTo(emailDTO2);
        cadastroEmailDTO1.setId(null);
        assertThat(cadastroEmailDTO1).isNotEqualTo(emailDTO2);
    }
}

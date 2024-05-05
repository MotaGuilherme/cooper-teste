package br.com.jj.coop.cooptest.model.dto.entrada;

import br.com.jj.coop.cooptest.model.dto.saida.EnderecoDTO;
import br.com.jj.coop.cooptest.util.CoopTestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CadastroEnderecoDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        CoopTestUtil.equalsVerifier(EnderecoDTO.class);
        EnderecoDTO enderecoDTO1 = new EnderecoDTO();
        enderecoDTO1.setId(1L);
        EnderecoDTO cadastroEnderecoDTO2 = new EnderecoDTO();
        assertThat(enderecoDTO1).isNotEqualTo(cadastroEnderecoDTO2);
        cadastroEnderecoDTO2.setId(enderecoDTO1.getId());
        assertThat(enderecoDTO1).isEqualTo(cadastroEnderecoDTO2);
        cadastroEnderecoDTO2.setId(2L);
        assertThat(enderecoDTO1).isNotEqualTo(cadastroEnderecoDTO2);
        enderecoDTO1.setId(null);
        assertThat(enderecoDTO1).isNotEqualTo(cadastroEnderecoDTO2);
    }
}

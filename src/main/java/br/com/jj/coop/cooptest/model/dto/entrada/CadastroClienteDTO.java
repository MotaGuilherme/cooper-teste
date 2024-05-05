package br.com.jj.coop.cooptest.model.dto.entrada;


import br.com.jj.coop.cooptest.model.entity.Email;
import br.com.jj.coop.cooptest.model.entity.Endereco;
import br.com.jj.coop.cooptest.model.entity.Telefone;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class CadastroClienteDTO {

    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String noCliente;

    @NotNull
    @CPF
    private String nuCpf;

    @Valid
    @NotEmpty
    private Set<CadastroEmailDTO> emails;

    @Valid
    @NotEmpty
    private Set<CadastroTelefoneDTO> telefones;

    @Valid
    @NotNull
    private CadastroEnderecoDTO endereco;
}

package br.com.jj.coop.cooptest.model.dto.saida;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

@Data
@EqualsAndHashCode
public class ClienteDTO implements Serializable {

    private Long id;
    private String noCliente;
    private String nuCpf;
    private Set<EmailDTO> emails;
    private Set<TelefoneDTO> telefones;
    private EnderecoDTO endereco;
}

package br.com.jj.coop.cooptest.model.dto.entrada;

import br.com.jj.coop.cooptest.model.enuns.TipoTelefone;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CadastroTelefoneDTO {
    private Long id;

    @NotNull
    private String nuTelefone;

    @NotNull
    private TipoTelefone coTipoTelefone;
}

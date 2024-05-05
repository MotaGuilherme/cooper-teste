package br.com.jj.coop.cooptest.model.dto.saida;

import br.com.jj.coop.cooptest.model.enuns.TipoTelefone;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class TelefoneDTO implements Serializable {

    private Long id;
    private String nuTelefone;
    private TipoTelefone coTipoTelefone;
}

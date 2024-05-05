package br.com.jj.coop.cooptest.model.dto.saida;

import br.com.jj.coop.cooptest.model.enuns.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {

    private Long id;
    private String nmUsuario;
    private String email;
    private Perfil perfil;
    private String dsLogin;
    private Boolean  stAtivo;
}
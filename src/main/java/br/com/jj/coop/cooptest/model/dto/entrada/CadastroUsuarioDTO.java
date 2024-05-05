package br.com.jj.coop.cooptest.model.dto.entrada;

import br.com.jj.coop.cooptest.model.enuns.Perfil;
import lombok.Data;

@Data
public class CadastroUsuarioDTO {

    private Long id;
    private String noUsuario;
    private String password;
    private String email;
    private Perfil perfil;
    private Boolean  stAtivo;
}
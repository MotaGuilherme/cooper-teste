package br.com.jj.coop.cooptest.service;

import br.com.jj.coop.cooptest.model.dto.saida.UsuarioDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

    UsuarioDTO getUsuarioLogado();
}

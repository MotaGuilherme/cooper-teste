package br.com.jj.coop.cooptest.service.impl;

import br.com.jj.coop.cooptest.model.dto.saida.UsuarioDTO;
import br.com.jj.coop.cooptest.model.entity.Usuario;
import br.com.jj.coop.cooptest.model.mapper.UsuarioMapper;
import br.com.jj.coop.cooptest.repository.UsuarioRepository;
import br.com.jj.coop.cooptest.service.UsuarioService;
import br.com.jj.coop.cooptest.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.jj.coop.cooptest.message.BusinessMessageProperty.USUARIO_NAO_LOCALIZADO;


@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByDsLoginIgnoreCase(login);

        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuário ou senha inválidos!");
        }

        return User.withUsername(usuario.get().getDsLogin())
                .password(usuario.get().getPassword())
                .roles(usuario.get().getPerfil().name())
                .build();

    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioLogado() {
        return SecurityUtils
                .getCurrentUserLogin()
                .flatMap(usuarioRepository::findUsuarioByDsLoginIgnoreCase)
                .map(usuarioMapper::toDto)
                .orElseThrow(USUARIO_NAO_LOCALIZADO::resourceNotFoundException);

    }

}

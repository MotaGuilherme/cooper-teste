package br.com.jj.coop.cooptest.controller;

import br.com.jj.coop.cooptest.config.security.jwt.JWTFilter;
import br.com.jj.coop.cooptest.config.security.jwt.TokenProvider;
import br.com.jj.coop.cooptest.model.dto.entrada.LoginDTO;
import br.com.jj.coop.cooptest.model.dto.saida.JwtDTO;
import br.com.jj.coop.cooptest.model.dto.saida.UsuarioDTO;
import br.com.jj.coop.cooptest.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Autenticação dos usuários do sistema")
public class AuthController {

    private final UsuarioService usuarioService;

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtDTO> authorize(@Valid @RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(),
                loginDTO.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, loginDTO.getRememberMe());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new JwtDTO(jwt), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<UsuarioDTO> conta() {
        final var dto = usuarioService.getUsuarioLogado();

        return ResponseEntity
                .ok()
                .body(dto);
    }
}

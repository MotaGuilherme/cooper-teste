package br.com.jj.coop.cooptest.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.jj.coop.cooptest.model.dto.entrada.CadastroClienteDTO;
import br.com.jj.coop.cooptest.model.dto.saida.ClienteDTO;
import br.com.jj.coop.cooptest.service.ClienteService;
import br.com.jj.coop.cooptest.util.PaginationUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
@Tag(name = "Cliente", description = "Operações sobre a entidade Cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping()
    @Operation(summary = "Cadastrar", description = "Cadastra um novo cliente")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody CadastroClienteDTO clienteDTO) {
        final var dto = clienteService.cadastrar(clienteDTO);

        final var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(location).body(dto);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza o cadastro do cliente")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ClienteDTO> atualizar( @PathVariable final Long id, @Valid @RequestBody CadastroClienteDTO cadastroClienteDTO) {
        final var dto = clienteService.atualizar(id, cadastroClienteDTO);

        return ResponseEntity
            .ok()
            .body(dto);
    }

    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    @Operation(summary = "Corrigir", description = "Corrige o registro do cliente")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ClienteDTO> corrigir(@PathVariable final Long id, @NotNull @RequestBody CadastroClienteDTO cadastroClienteDTO) {
        final var dto = clienteService.corrigir(id, cadastroClienteDTO);

        return ResponseEntity
                .ok()
                .body(dto);
    }

    @GetMapping()
    @Operation(summary = "Recuperar todos", description = "Recupera todos os clientes paginados")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR','COMUM')")
    public ResponseEntity<List<ClienteDTO>> recuperarTodos(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        Page<ClienteDTO> page = clienteService.recuperarTodos(pageable);
        HttpHeaders headers = PaginationUtil.getPaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recuperar", description = "Recuperar um cliente por ID")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR','COMUM')")
    public ResponseEntity<ClienteDTO> recuperar(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.recuperar(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @Operation(summary = "Excluir", description = "Excluir um cliente por ID")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().cacheControl(CacheControl.noCache()).build();
    }
}

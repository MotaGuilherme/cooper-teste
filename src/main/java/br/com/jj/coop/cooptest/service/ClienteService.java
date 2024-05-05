package br.com.jj.coop.cooptest.service;

import br.com.jj.coop.cooptest.model.dto.entrada.CadastroClienteDTO;
import br.com.jj.coop.cooptest.model.dto.saida.ClienteDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClienteService {

    ClienteDTO cadastrar(CadastroClienteDTO clienteDTO);

    ClienteDTO atualizar(Long id, CadastroClienteDTO cadastroClienteDTO);

    ClienteDTO corrigir(Long id, CadastroClienteDTO cadastroClienteDTO);

    Page<ClienteDTO> recuperarTodos(Pageable pageable);

    void excluir(Long id);

    ClienteDTO recuperar(Long id);
}


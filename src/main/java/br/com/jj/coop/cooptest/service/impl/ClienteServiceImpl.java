package br.com.jj.coop.cooptest.service.impl;


import br.com.jj.coop.cooptest.model.dto.entrada.CadastroClienteDTO;
import br.com.jj.coop.cooptest.model.dto.saida.ClienteDTO;
import br.com.jj.coop.cooptest.model.mapper.ClienteMapper;
import br.com.jj.coop.cooptest.repository.ClienteRepository;
import br.com.jj.coop.cooptest.repository.EmailRepository;
import br.com.jj.coop.cooptest.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static br.com.jj.coop.cooptest.message.BusinessMessageProperty.*;
import static br.com.jj.coop.cooptest.message.CoreMessageProperty.API_ACCESS_FORBIDDEN;
import static br.com.jj.coop.cooptest.message.CoreMessageProperty.API_RESOURCE_NOTFOUND;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final EmailRepository emailRepository;

    private final ClienteMapper clienteMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ClienteDTO cadastrar(CadastroClienteDTO clienteDTO) {
        final var cliente = clienteMapper.fromRegister(clienteDTO);

        if(clienteRepository.existsByNuCpf(cliente.getNuCpf())){
            throw CLIENTE_CPF_JA_CADASTRADO.businessException();
        }

        cliente.getEmails().forEach(email -> {
            if (emailRepository.existsByDsEmail(email.getDsEmail())) {
                throw CLIENTE_EMAIL_JA_CADASTRADO.businessException();
            }
            email.setCliente(cliente);
        });
        cliente.getTelefones().forEach(tel -> tel.setCliente(cliente));
        cliente.getEndereco().setCliente(cliente);

        clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void excluir(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw API_RESOURCE_NOTFOUND.resourceNotFoundException();
        }
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO recuperar(Long id) {
        final var entity = clienteRepository.findById(id)
                .orElseThrow(API_RESOURCE_NOTFOUND::resourceNotFoundException);
        return clienteMapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClienteDTO> recuperarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable).map(clienteMapper::toDto);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ClienteDTO corrigir(Long id, CadastroClienteDTO cadastroClienteDTO) {

        if(!id.equals(cadastroClienteDTO.getId())) {
            throw API_ACCESS_FORBIDDEN.accessForbiddenException();
        }

        if(cadastroClienteDTO.getId() == null) {
            throw CLIENTE_INVALIDO.businessException();
        }

        if (!clienteRepository.existsById(cadastroClienteDTO.getId())) {
            throw API_RESOURCE_NOTFOUND.resourceNotFoundException();
        }

        return clienteRepository
                .findById(cadastroClienteDTO.getId())
                .map(cliente -> {
                    clienteMapper.partialUpdate(cliente, cadastroClienteDTO);
                    return cliente;
                })
                .map(clienteRepository::save)
                .map(clienteMapper::toDto)
                .orElseThrow(API_RESOURCE_NOTFOUND::resourceNotFoundException);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ClienteDTO atualizar(Long id, CadastroClienteDTO cadastroClienteDTO) {

        if(!id.equals(cadastroClienteDTO.getId())) {
            throw API_ACCESS_FORBIDDEN.accessForbiddenException();
        }

        if(cadastroClienteDTO.getId() == null) {
            throw CLIENTE_INVALIDO.businessException();
        }

        if (!clienteRepository.existsById(cadastroClienteDTO.getId())) {
            throw API_RESOURCE_NOTFOUND.resourceNotFoundException();
        }

         var cliente = clienteMapper.fromRegister(cadastroClienteDTO);

        cliente.getEmails().forEach(email -> email.setCliente(cliente));
        cliente.getTelefones().forEach(tel -> tel.setCliente(cliente));
        cliente.getEndereco().setCliente(cliente);

        clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }


}

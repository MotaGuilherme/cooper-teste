package br.com.jj.coop.cooptest.model.mapper;

import br.com.jj.coop.cooptest.model.dto.entrada.CadastroClienteDTO;
import br.com.jj.coop.cooptest.model.dto.entrada.CadastroEmailDTO;
import br.com.jj.coop.cooptest.model.dto.entrada.CadastroEnderecoDTO;
import br.com.jj.coop.cooptest.model.dto.entrada.CadastroTelefoneDTO;
import br.com.jj.coop.cooptest.model.dto.saida.ClienteDTO;
import br.com.jj.coop.cooptest.model.dto.saida.EmailDTO;
import br.com.jj.coop.cooptest.model.dto.saida.EnderecoDTO;
import br.com.jj.coop.cooptest.model.dto.saida.TelefoneDTO;
import br.com.jj.coop.cooptest.model.entity.Cliente;
import br.com.jj.coop.cooptest.model.entity.Email;
import br.com.jj.coop.cooptest.model.entity.Endereco;
import br.com.jj.coop.cooptest.model.entity.Telefone;
import br.com.jj.coop.cooptest.model.entity.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-04T21:25:23-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO toDto(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( entity.getId() );
        clienteDTO.setNoCliente( entity.getNoCliente() );
        clienteDTO.setNuCpf( entity.getNuCpf() );
        clienteDTO.setEmails( emailSetToEmailDTOSet( entity.getEmails() ) );
        clienteDTO.setTelefones( telefoneSetToTelefoneDTOSet( entity.getTelefones() ) );
        clienteDTO.setEndereco( enderecoToEnderecoDTO( entity.getEndereco() ) );

        return clienteDTO;
    }

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( dto.getId() );
        cliente.setNoCliente( dto.getNoCliente() );
        cliente.setNuCpf( dto.getNuCpf() );
        cliente.setEmails( emailDTOSetToEmailSet( dto.getEmails() ) );
        cliente.setTelefones( telefoneDTOSetToTelefoneSet( dto.getTelefones() ) );
        cliente.setEndereco( enderecoDTOToEndereco( dto.getEndereco() ) );

        return cliente;
    }

    @Override
    public Cliente fromRegister(CadastroClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( dto.getId() );
        cliente.setNoCliente( dto.getNoCliente() );
        cliente.setNuCpf( dto.getNuCpf() );
        cliente.setEmails( cadastroEmailDTOSetToEmailSet( dto.getEmails() ) );
        cliente.setTelefones( cadastroTelefoneDTOSetToTelefoneSet( dto.getTelefones() ) );
        cliente.setEndereco( cadastroEnderecoDTOToEndereco( dto.getEndereco() ) );

        return cliente;
    }

    @Override
    public List<ClienteDTO> toDto(List<Cliente> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( entities.size() );
        for ( Cliente cliente : entities ) {
            list.add( toDto( cliente ) );
        }

        return list;
    }

    @Override
    public List<ClienteDTO> toDto(Iterable<Cliente> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>();
        for ( Cliente cliente : entities ) {
            list.add( toDto( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toEntity(List<ClienteDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( dtos.size() );
        for ( ClienteDTO clienteDTO : dtos ) {
            list.add( toEntity( clienteDTO ) );
        }

        return list;
    }

    @Override
    public List<Cliente> fromRegister(List<CadastroClienteDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( dtos.size() );
        for ( CadastroClienteDTO cadastroClienteDTO : dtos ) {
            list.add( fromRegister( cadastroClienteDTO ) );
        }

        return list;
    }

    @Override
    public void fromDto(ClienteDTO dto, Cliente entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setNoCliente( dto.getNoCliente() );
        entity.setNuCpf( dto.getNuCpf() );
        if ( entity.getEmails() != null ) {
            Set<Email> set = emailDTOSetToEmailSet( dto.getEmails() );
            if ( set != null ) {
                entity.getEmails().clear();
                entity.getEmails().addAll( set );
            }
            else {
                entity.setEmails( null );
            }
        }
        else {
            Set<Email> set = emailDTOSetToEmailSet( dto.getEmails() );
            if ( set != null ) {
                entity.setEmails( set );
            }
        }
        if ( entity.getTelefones() != null ) {
            Set<Telefone> set1 = telefoneDTOSetToTelefoneSet( dto.getTelefones() );
            if ( set1 != null ) {
                entity.getTelefones().clear();
                entity.getTelefones().addAll( set1 );
            }
            else {
                entity.setTelefones( null );
            }
        }
        else {
            Set<Telefone> set1 = telefoneDTOSetToTelefoneSet( dto.getTelefones() );
            if ( set1 != null ) {
                entity.setTelefones( set1 );
            }
        }
        if ( dto.getEndereco() != null ) {
            if ( entity.getEndereco() == null ) {
                entity.setEndereco( new Endereco() );
            }
            enderecoDTOToEndereco1( dto.getEndereco(), entity.getEndereco() );
        }
        else {
            entity.setEndereco( null );
        }
    }

    @Override
    public void fromDto(ClienteDTO dto, Usuario entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
    }

    @Override
    public void partialUpdate(Cliente entity, CadastroClienteDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNoCliente() != null ) {
            entity.setNoCliente( dto.getNoCliente() );
        }
        if ( dto.getNuCpf() != null ) {
            entity.setNuCpf( dto.getNuCpf() );
        }
        if ( entity.getEmails() != null ) {
            Set<Email> set = cadastroEmailDTOSetToEmailSet( dto.getEmails() );
            if ( set != null ) {
                entity.getEmails().clear();
                entity.getEmails().addAll( set );
            }
        }
        else {
            Set<Email> set = cadastroEmailDTOSetToEmailSet( dto.getEmails() );
            if ( set != null ) {
                entity.setEmails( set );
            }
        }
        if ( entity.getTelefones() != null ) {
            Set<Telefone> set1 = cadastroTelefoneDTOSetToTelefoneSet( dto.getTelefones() );
            if ( set1 != null ) {
                entity.getTelefones().clear();
                entity.getTelefones().addAll( set1 );
            }
        }
        else {
            Set<Telefone> set1 = cadastroTelefoneDTOSetToTelefoneSet( dto.getTelefones() );
            if ( set1 != null ) {
                entity.setTelefones( set1 );
            }
        }
        if ( dto.getEndereco() != null ) {
            if ( entity.getEndereco() == null ) {
                entity.setEndereco( new Endereco() );
            }
            cadastroEnderecoDTOToEndereco1( dto.getEndereco(), entity.getEndereco() );
        }
    }

    protected EmailDTO emailToEmailDTO(Email email) {
        if ( email == null ) {
            return null;
        }

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setId( email.getId() );
        emailDTO.setDsEmail( email.getDsEmail() );

        return emailDTO;
    }

    protected Set<EmailDTO> emailSetToEmailDTOSet(Set<Email> set) {
        if ( set == null ) {
            return null;
        }

        Set<EmailDTO> set1 = new HashSet<EmailDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Email email : set ) {
            set1.add( emailToEmailDTO( email ) );
        }

        return set1;
    }

    protected TelefoneDTO telefoneToTelefoneDTO(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneDTO telefoneDTO = new TelefoneDTO();

        telefoneDTO.setId( telefone.getId() );
        telefoneDTO.setNuTelefone( telefone.getNuTelefone() );
        telefoneDTO.setCoTipoTelefone( telefone.getCoTipoTelefone() );

        return telefoneDTO;
    }

    protected Set<TelefoneDTO> telefoneSetToTelefoneDTOSet(Set<Telefone> set) {
        if ( set == null ) {
            return null;
        }

        Set<TelefoneDTO> set1 = new HashSet<TelefoneDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Telefone telefone : set ) {
            set1.add( telefoneToTelefoneDTO( telefone ) );
        }

        return set1;
    }

    protected EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId( endereco.getId() );
        if ( endereco.getNuCep() != null ) {
            enderecoDTO.setNuCep( endereco.getNuCep().longValue() );
        }
        enderecoDTO.setDsLogradouro( endereco.getDsLogradouro() );
        enderecoDTO.setNoBairro( endereco.getNoBairro() );
        enderecoDTO.setNoCidade( endereco.getNoCidade() );
        enderecoDTO.setCoUf( endereco.getCoUf() );
        enderecoDTO.setDsComplemento( endereco.getDsComplemento() );

        return enderecoDTO;
    }

    protected Email emailDTOToEmail(EmailDTO emailDTO) {
        if ( emailDTO == null ) {
            return null;
        }

        Email email = new Email();

        email.setId( emailDTO.getId() );
        email.setDsEmail( emailDTO.getDsEmail() );

        return email;
    }

    protected Set<Email> emailDTOSetToEmailSet(Set<EmailDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Email> set1 = new HashSet<Email>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( EmailDTO emailDTO : set ) {
            set1.add( emailDTOToEmail( emailDTO ) );
        }

        return set1;
    }

    protected Telefone telefoneDTOToTelefone(TelefoneDTO telefoneDTO) {
        if ( telefoneDTO == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setId( telefoneDTO.getId() );
        telefone.setNuTelefone( telefoneDTO.getNuTelefone() );
        telefone.setCoTipoTelefone( telefoneDTO.getCoTipoTelefone() );

        return telefone;
    }

    protected Set<Telefone> telefoneDTOSetToTelefoneSet(Set<TelefoneDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Telefone> set1 = new HashSet<Telefone>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TelefoneDTO telefoneDTO : set ) {
            set1.add( telefoneDTOToTelefone( telefoneDTO ) );
        }

        return set1;
    }

    protected Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( enderecoDTO.getId() );
        if ( enderecoDTO.getNuCep() != null ) {
            endereco.setNuCep( enderecoDTO.getNuCep().intValue() );
        }
        endereco.setDsLogradouro( enderecoDTO.getDsLogradouro() );
        endereco.setNoBairro( enderecoDTO.getNoBairro() );
        endereco.setNoCidade( enderecoDTO.getNoCidade() );
        endereco.setCoUf( enderecoDTO.getCoUf() );
        endereco.setDsComplemento( enderecoDTO.getDsComplemento() );

        return endereco;
    }

    protected Email cadastroEmailDTOToEmail(CadastroEmailDTO cadastroEmailDTO) {
        if ( cadastroEmailDTO == null ) {
            return null;
        }

        Email email = new Email();

        email.setId( cadastroEmailDTO.getId() );
        email.setDsEmail( cadastroEmailDTO.getDsEmail() );

        return email;
    }

    protected Set<Email> cadastroEmailDTOSetToEmailSet(Set<CadastroEmailDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Email> set1 = new HashSet<Email>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CadastroEmailDTO cadastroEmailDTO : set ) {
            set1.add( cadastroEmailDTOToEmail( cadastroEmailDTO ) );
        }

        return set1;
    }

    protected Telefone cadastroTelefoneDTOToTelefone(CadastroTelefoneDTO cadastroTelefoneDTO) {
        if ( cadastroTelefoneDTO == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setId( cadastroTelefoneDTO.getId() );
        telefone.setNuTelefone( cadastroTelefoneDTO.getNuTelefone() );
        telefone.setCoTipoTelefone( cadastroTelefoneDTO.getCoTipoTelefone() );

        return telefone;
    }

    protected Set<Telefone> cadastroTelefoneDTOSetToTelefoneSet(Set<CadastroTelefoneDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Telefone> set1 = new HashSet<Telefone>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CadastroTelefoneDTO cadastroTelefoneDTO : set ) {
            set1.add( cadastroTelefoneDTOToTelefone( cadastroTelefoneDTO ) );
        }

        return set1;
    }

    protected Endereco cadastroEnderecoDTOToEndereco(CadastroEnderecoDTO cadastroEnderecoDTO) {
        if ( cadastroEnderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( cadastroEnderecoDTO.getId() );
        endereco.setNuCep( cadastroEnderecoDTO.getNuCep() );
        endereco.setDsLogradouro( cadastroEnderecoDTO.getDsLogradouro() );
        endereco.setNoBairro( cadastroEnderecoDTO.getNoBairro() );
        endereco.setNoCidade( cadastroEnderecoDTO.getNoCidade() );
        endereco.setCoUf( cadastroEnderecoDTO.getCoUf() );
        endereco.setDsComplemento( cadastroEnderecoDTO.getDsComplemento() );

        return endereco;
    }

    protected void enderecoDTOToEndereco1(EnderecoDTO enderecoDTO, Endereco mappingTarget) {
        if ( enderecoDTO == null ) {
            return;
        }

        mappingTarget.setId( enderecoDTO.getId() );
        if ( enderecoDTO.getNuCep() != null ) {
            mappingTarget.setNuCep( enderecoDTO.getNuCep().intValue() );
        }
        else {
            mappingTarget.setNuCep( null );
        }
        mappingTarget.setDsLogradouro( enderecoDTO.getDsLogradouro() );
        mappingTarget.setNoBairro( enderecoDTO.getNoBairro() );
        mappingTarget.setNoCidade( enderecoDTO.getNoCidade() );
        mappingTarget.setCoUf( enderecoDTO.getCoUf() );
        mappingTarget.setDsComplemento( enderecoDTO.getDsComplemento() );
    }

    protected void cadastroEnderecoDTOToEndereco1(CadastroEnderecoDTO cadastroEnderecoDTO, Endereco mappingTarget) {
        if ( cadastroEnderecoDTO == null ) {
            return;
        }

        if ( cadastroEnderecoDTO.getId() != null ) {
            mappingTarget.setId( cadastroEnderecoDTO.getId() );
        }
        if ( cadastroEnderecoDTO.getNuCep() != null ) {
            mappingTarget.setNuCep( cadastroEnderecoDTO.getNuCep() );
        }
        if ( cadastroEnderecoDTO.getDsLogradouro() != null ) {
            mappingTarget.setDsLogradouro( cadastroEnderecoDTO.getDsLogradouro() );
        }
        if ( cadastroEnderecoDTO.getNoBairro() != null ) {
            mappingTarget.setNoBairro( cadastroEnderecoDTO.getNoBairro() );
        }
        if ( cadastroEnderecoDTO.getNoCidade() != null ) {
            mappingTarget.setNoCidade( cadastroEnderecoDTO.getNoCidade() );
        }
        if ( cadastroEnderecoDTO.getCoUf() != null ) {
            mappingTarget.setCoUf( cadastroEnderecoDTO.getCoUf() );
        }
        if ( cadastroEnderecoDTO.getDsComplemento() != null ) {
            mappingTarget.setDsComplemento( cadastroEnderecoDTO.getDsComplemento() );
        }
    }
}

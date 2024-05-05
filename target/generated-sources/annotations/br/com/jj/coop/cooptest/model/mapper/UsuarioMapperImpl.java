package br.com.jj.coop.cooptest.model.mapper;

import br.com.jj.coop.cooptest.model.dto.entrada.CadastroUsuarioDTO;
import br.com.jj.coop.cooptest.model.dto.saida.UsuarioDTO;
import br.com.jj.coop.cooptest.model.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-04T21:25:23-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDto(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setNmUsuario( entity.getNmUsuario() );
        usuarioDTO.setEmail( entity.getEmail() );
        usuarioDTO.setPerfil( entity.getPerfil() );
        usuarioDTO.setDsLogin( entity.getDsLogin() );
        usuarioDTO.setStAtivo( entity.getStAtivo() );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setNmUsuario( dto.getNmUsuario() );
        usuario.setDsLogin( dto.getDsLogin() );
        usuario.setEmail( dto.getEmail() );
        usuario.setPerfil( dto.getPerfil() );
        usuario.setStAtivo( dto.getStAtivo() );

        return usuario;
    }

    @Override
    public Usuario fromRegister(CadastroUsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setPassword( dto.getPassword() );
        usuario.setEmail( dto.getEmail() );
        usuario.setPerfil( dto.getPerfil() );
        usuario.setStAtivo( dto.getStAtivo() );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toDto(List<Usuario> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( entities.size() );
        for ( Usuario usuario : entities ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }

    @Override
    public List<UsuarioDTO> toDto(Iterable<Usuario> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>();
        for ( Usuario usuario : entities ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toEntity(List<UsuarioDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtos.size() );
        for ( UsuarioDTO usuarioDTO : dtos ) {
            list.add( toEntity( usuarioDTO ) );
        }

        return list;
    }

    @Override
    public List<Usuario> fromRegister(List<CadastroUsuarioDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtos.size() );
        for ( CadastroUsuarioDTO cadastroUsuarioDTO : dtos ) {
            list.add( fromRegister( cadastroUsuarioDTO ) );
        }

        return list;
    }

    @Override
    public void fromDto(UsuarioDTO dto, Usuario entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setNmUsuario( dto.getNmUsuario() );
        entity.setDsLogin( dto.getDsLogin() );
        entity.setEmail( dto.getEmail() );
        entity.setPerfil( dto.getPerfil() );
        entity.setStAtivo( dto.getStAtivo() );
    }
}

package br.com.jj.coop.cooptest.model.mapper;

import br.com.jj.coop.cooptest.model.dto.entrada.CadastroUsuarioDTO;
import br.com.jj.coop.cooptest.model.dto.saida.UsuarioDTO;
import br.com.jj.coop.cooptest.model.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO, CadastroUsuarioDTO> {

    @InheritInverseConfiguration(name = "toDto")
    void fromDto(UsuarioDTO dto, @MappingTarget Usuario entity);

}

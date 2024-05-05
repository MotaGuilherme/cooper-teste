package br.com.jj.coop.cooptest.model.mapper;

import br.com.jj.coop.cooptest.model.dto.entrada.CadastroClienteDTO;
import br.com.jj.coop.cooptest.model.dto.saida.ClienteDTO;
import br.com.jj.coop.cooptest.model.entity.Cliente;
import br.com.jj.coop.cooptest.model.entity.Usuario;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO, CadastroClienteDTO> {

    @InheritInverseConfiguration(name = "toDto")
    void fromDto(ClienteDTO dto, @MappingTarget Usuario entity);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Cliente entity, CadastroClienteDTO dto);
}

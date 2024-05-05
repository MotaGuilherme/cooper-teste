package br.com.jj.coop.cooptest.model.dto.entrada;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class CadastroEnderecoDTO {
    private Long id;

    @NotNull
    private Integer nuCep;

    @NotNull
    private String dsLogradouro;

    @NotNull
    private String noBairro;

    @NotNull
    private String noCidade;

    @NotNull
    private String coUf;

    private String dsComplemento;
}

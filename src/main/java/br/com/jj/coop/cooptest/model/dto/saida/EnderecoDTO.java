package br.com.jj.coop.cooptest.model.dto.saida;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@EqualsAndHashCode
public class EnderecoDTO implements Serializable {
    private Long id;

    @NotNull
    @JsonAlias({"cep", "nuCep"})
    private Long nuCep;

    @NotNull
    @JsonAlias({"logradouro", "street"})
    private String dsLogradouro;

    @NotNull
    @JsonAlias({"noBairro", "neighborhood"})
    private String noBairro;

    @NotNull
    @JsonAlias({"noCidade", "city"})
    private String noCidade;

    @NotNull
    @JsonAlias({"state", "coUf"})
    private String coUf;

    private String dsComplemento;
}

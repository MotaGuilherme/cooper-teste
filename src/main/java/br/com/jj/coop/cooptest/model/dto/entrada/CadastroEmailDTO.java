package br.com.jj.coop.cooptest.model.dto.entrada;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class CadastroEmailDTO {

    private Long id;

    @Email
    @NotNull
    private String dsEmail;
}

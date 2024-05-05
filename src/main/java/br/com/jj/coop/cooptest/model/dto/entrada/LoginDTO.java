package br.com.jj.coop.cooptest.model.dto.entrada;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;

    private Boolean rememberMe = false;
}
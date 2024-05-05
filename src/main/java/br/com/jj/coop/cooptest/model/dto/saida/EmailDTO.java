package br.com.jj.coop.cooptest.model.dto.saida;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@EqualsAndHashCode
public class EmailDTO implements Serializable {

    private Long id;

    private String dsEmail;
}

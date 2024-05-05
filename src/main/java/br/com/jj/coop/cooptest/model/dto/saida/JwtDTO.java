package br.com.jj.coop.cooptest.model.dto.saida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class JwtDTO implements Serializable {

    private String token;
}

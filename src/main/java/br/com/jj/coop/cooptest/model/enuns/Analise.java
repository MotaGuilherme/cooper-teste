package br.com.jj.coop.cooptest.model.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Analise {

    APROVADO(0, "Aprovado"),
    REPROVADO(1, "Reprovado"),
    NAO_REALIZADO(2, "Não Realizado");

    private Integer id;
    private String descricao;
}

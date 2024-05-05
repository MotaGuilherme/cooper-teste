package br.com.jj.coop.cooptest.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;

@Getter
@RequiredArgsConstructor
public enum BusinessMessageProperty implements MessageProperty {

    CLIENTE_EMAIL_JA_CADASTRADO("cliente.email-ja-cadastrado"),
    CLIENTE_CPF_JA_CADASTRADO("cliente.cpf-ja-cadastrado"),
    CLIENTE_INVALIDO("cliente.invalido"),

    USUARIO_SENHA_INVALIDO("usuario.email-senha-invalido"),
    USUARIO_LINK_INVALIDO("usuario.link-ativar-conta-invalido"),
    USUARIO_NAO_LOCALIZADO("usuario.nao-localizado"),

    CEP_NAO_LOCALIZADO("cep.nao-localizado"),
    CEP_ERRO_CONSULTA("cep.erro-consulta");

    private final String key;

    private String[] args = {};

    public String key() {
        return key;
    }

    public MessageProperty bind(String... pArgs) {
        this.args = ArrayUtils.isNotEmpty(pArgs) ? pArgs : null;
        return this;
    }
}

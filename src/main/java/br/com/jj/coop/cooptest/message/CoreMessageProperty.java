package br.com.jj.coop.cooptest.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;

@Getter
@RequiredArgsConstructor
public enum CoreMessageProperty implements MessageProperty {

    API_ACCESS_FORBIDDEN("api.access-forbidden"),
    API_UNDENTIFIED_ERROR("api.unidentified-error"),
    API_RESOURCE_NOTFOUND("api.resource-notfound"),
    API_DUPLICATE_KEY("api.duplicate-key-error");


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

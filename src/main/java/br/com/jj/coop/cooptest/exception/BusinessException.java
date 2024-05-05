package br.com.jj.coop.cooptest.exception;


import br.com.jj.coop.cooptest.message.MessageProperty;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BusinessException extends CoopException {

    private final List<MessageProperty> messages = new ArrayList<>();

    @Deprecated
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(MessageProperty message) {
        super(message);
        this.messages.add(message);
    }

    public BusinessException(MessageProperty... pMessages) {
        super(ArrayUtils.isNotEmpty(pMessages) ?Arrays.stream(pMessages).map(MessageProperty::message).collect(Collectors.joining()) : StringUtils.EMPTY);
        this.messages.addAll(Arrays.asList(pMessages));
    }

    public BusinessException(MessageProperty message, Throwable cause) {
        super(message, cause);
        this.messages.add(message);
    }

}

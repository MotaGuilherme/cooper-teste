package br.com.jj.coop.cooptest.exception;

import br.com.jj.coop.cooptest.message.MessageProperty;

public class AccessForbiddenException extends CoopException {
    private static final long serialVersionUID = 9140369879016050191L;

    public AccessForbiddenException() {
        super();
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    public AccessForbiddenException(MessageProperty messageProperty) {
        super(messageProperty);
    }

    public AccessForbiddenException(String message, MessageProperty messageProperty) {
        super(message, messageProperty);
    }

    public AccessForbiddenException(String message, Throwable cause, MessageProperty messageProperty) {
        super(message, cause, messageProperty);
    }

    public AccessForbiddenException(Throwable cause, MessageProperty messageProperty) {
        super(messageProperty, cause);
    }
}

package br.com.jj.coop.cooptest.exception;

import br.com.jj.coop.cooptest.message.MessageProperty;

public class InfraException extends CoopException {
    private static final long serialVersionUID = 7573649955339961375L;

    public InfraException() {
        super();
    }

    public InfraException(String message) {
        super(message);
    }

    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfraException(Throwable cause) {
        super(cause);
    }

    public InfraException(MessageProperty messageProperty) {
        super(messageProperty);
    }

    public InfraException(String message, MessageProperty messageProperty) {
        super(message, messageProperty);
    }

    public InfraException(String message, Throwable cause, MessageProperty messageProperty) {
        super(message, cause, messageProperty);
    }

    public InfraException(MessageProperty messageProperty, Throwable cause) {
        super(messageProperty, cause);
    }
}

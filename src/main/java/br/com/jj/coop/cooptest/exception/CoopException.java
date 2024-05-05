package br.com.jj.coop.cooptest.exception;


import br.com.jj.coop.cooptest.message.MessageProperty;

import java.util.Optional;

public abstract class CoopException extends RuntimeException {
    private static final long serialVersionUID = -3485074360659570937L;

    private final MessageProperty messageProperty;

    public Optional<MessageProperty> getMessageField() {
        return Optional.ofNullable(messageProperty);
    }

    protected CoopException() {
        super();
        this.messageProperty = null;
    }

    protected CoopException(String message) {
        super(message);
        this.messageProperty = null;
    }

    protected CoopException(String message, Throwable cause) {
        super(message, cause);
        this.messageProperty = null;
    }

    protected CoopException(Throwable cause) {
        super(cause);
        this.messageProperty = null;
    }

    protected CoopException(MessageProperty messageProperty) {
        super(messageProperty.message());
        this.messageProperty = messageProperty;
    }

    protected CoopException(String message, MessageProperty messageProperty) {
        super(message);
        this.messageProperty = messageProperty;
    }

    protected CoopException(String message, Throwable cause, MessageProperty messageProperty) {
        super(message, cause);
        this.messageProperty = messageProperty;
    }

    protected CoopException(MessageProperty messageProperty, Throwable cause) {
        super(messageProperty.message(), cause);
        this.messageProperty = messageProperty;
    }
}

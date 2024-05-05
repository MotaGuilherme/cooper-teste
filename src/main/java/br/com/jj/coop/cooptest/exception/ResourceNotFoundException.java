package br.com.jj.coop.cooptest.exception;


import br.com.jj.coop.cooptest.message.MessageProperty;

public class ResourceNotFoundException extends CoopException {
    private static final long serialVersionUID = 8351575330036082791L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(MessageProperty messageProperty) {
        super(messageProperty);
    }

    public ResourceNotFoundException(String message, MessageProperty messageProperty) {
        super(message, messageProperty);
    }

    public ResourceNotFoundException(String message, Throwable cause, MessageProperty messageProperty) {
        super(message, cause, messageProperty);
    }

    public ResourceNotFoundException(MessageProperty messageProperty, Throwable cause) {
        super(messageProperty, cause);
    }
}

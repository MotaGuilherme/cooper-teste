package br.com.jj.coop.cooptest.message;


import br.com.jj.coop.cooptest.exception.AccessForbiddenException;
import br.com.jj.coop.cooptest.exception.BusinessException;
import br.com.jj.coop.cooptest.exception.InfraException;
import br.com.jj.coop.cooptest.exception.ResourceNotFoundException;

import java.io.Serializable;

public interface MessageProperty extends Serializable {

    String key();
    String[] getArgs();

    MessageProperty bind(String... pArgs);

    default String message() {
        if (getArgs().length == 0) {
            return MessageSource.get().message(key());
        }
        return MessageSource.get().message(key(), getArgs());
    }

    default BusinessException businessException() {
        return new BusinessException(this);
    }

    default BusinessException businessException(Throwable cause) {
        return new BusinessException(this, cause);
    }

    default InfraException infraException() {
        return new InfraException(this);
    }

    default InfraException infraException(Throwable cause) {
        return new InfraException(this, cause);
    }

    default ResourceNotFoundException resourceNotFoundException() {
        return new ResourceNotFoundException(this);
    }

    default ResourceNotFoundException resourceNotFoundException(Throwable cause) {
        return new ResourceNotFoundException(this, cause);
    }

    default AccessForbiddenException accessForbiddenException() {
        return new AccessForbiddenException(this);
    }
    default AccessForbiddenException accessForbiddenException(Throwable cause) {
        return new AccessForbiddenException(cause, this);
    }


}

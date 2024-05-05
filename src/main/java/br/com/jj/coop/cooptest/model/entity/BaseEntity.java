package br.com.jj.coop.cooptest.model.entity;

import java.io.Serializable;

public abstract class BaseEntity<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -7688927080527892653L;

    public abstract T getId();

    public abstract void setId(T id);

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public final String toString() {
        final var entidade = this.getClass().getSimpleName();
        return "Entidade [ " + entidade + " ] {" + "id=" + getId() + '}';
    }

}
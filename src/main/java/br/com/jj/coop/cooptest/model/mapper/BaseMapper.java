package br.com.jj.coop.cooptest.model.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<E, D, R> {

    D toDto(E entity);

    E toEntity(D dto);
    E fromRegister(R dto);

    List<D> toDto(List<E> entities);

    List<D> toDto(Iterable<E> entities);

    List<E> toEntity(List<D> dtos);
    List<E> fromRegister(List<R> dtos);

    void fromDto(D dto, @MappingTarget E entity);

}
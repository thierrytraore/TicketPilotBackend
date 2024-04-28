package com.exnihilo.domains.mappers;

import com.exnihilo.domains.entities.BaseEntity;
import org.mapstruct.MappingTarget;

import java.io.Serializable;

public interface BaseMapper<T extends BaseEntity, D extends Serializable> {
    T toEntity(D d);

    D toDto(T t);

    T partialUpdate(D d, @MappingTarget T t);
}

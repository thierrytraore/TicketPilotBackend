package com.exnihilo.services;

import java.io.Serializable;
import java.util.List;

public interface BaseService<D extends Serializable, ID> {

    List<D> getAll();

    D getById(ID id);

    D create(D d);

    D update(ID id, D d);

    void delete(ID id);

    long count();

}

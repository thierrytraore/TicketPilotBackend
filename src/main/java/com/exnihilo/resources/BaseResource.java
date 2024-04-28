package com.exnihilo.resources;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseResource<D extends Serializable, ID> {

    ResponseEntity<List<D>> getAll();

    ResponseEntity<D> getById(ID id);

    ResponseEntity<D> create(D dto);

    ResponseEntity<D> update(ID id, D dto);

    ResponseEntity<Void> deleteById(ID id);

    ResponseEntity<Long> count();

}

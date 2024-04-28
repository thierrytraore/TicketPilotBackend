package com.exnihilo.services.impl;

import com.exnihilo.domains.entities.BaseEntity;
import com.exnihilo.domains.mappers.BaseMapper;
import com.exnihilo.repositories.BaseRepository;
import com.exnihilo.services.BaseService;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity, D extends Serializable, ID> implements BaseService<D, ID> {

    private final BaseRepository<T, ID> repository;
    private final BaseMapper<T, D> mapper;

    @Override
    public List<D> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public D getById(ID id) throws IllegalArgumentException, NoSuchElementException {
        Optional.ofNullable(id).orElseThrow(() -> new IllegalArgumentException("Cannot find entity: argument 'id' is null."));
        T t = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Entity not found with id '" + id + "'."));
        return mapper.toDto(t);
    }

    @Override
    public D create(D d) throws IllegalArgumentException {
        Optional.ofNullable(d).orElseThrow(() -> new IllegalArgumentException("Cannot create entity: argument 'd' is null."));
        T t = repository.save(mapper.toEntity(d));
        return mapper.toDto(t);
    }

    @Override
    public D update(ID id, D d) throws IllegalArgumentException, NoSuchElementException {
        Optional.ofNullable(id).orElseThrow(() -> new IllegalArgumentException("Cannot update entity: argument 'id' is null."));
        Optional.ofNullable(d).orElseThrow(() -> new IllegalArgumentException("Cannot update entity: argument 'd' is null."));
        T t = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Cannot update entity: entity with id '" + id + "' not found."));
        mapper.partialUpdate(d, t);
        return mapper.toDto(t);
    }

    @Override
    public void delete(ID id) throws IllegalArgumentException, NoSuchElementException {
        Optional.ofNullable(id).orElseThrow(() -> new IllegalArgumentException("Cannot delete entity: argument 'id' is null."));
        T t = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Cannot delete entity: entity with id '" + id + "' not found."));
        repository.delete(t);
    }

    @Override
    public long count() {
        return repository.count();
    }

}

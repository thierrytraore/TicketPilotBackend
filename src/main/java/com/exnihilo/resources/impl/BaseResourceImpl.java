package com.exnihilo.resources.impl;

import com.exnihilo.resources.BaseResource;
import com.exnihilo.services.BaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public class BaseResourceImpl<D extends Serializable, ID> implements BaseResource<D, ID> {

    private final BaseService<D, ID> service;

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<D>> getAll() {
        List<D> result = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getById/{id}")
    @Override
    public ResponseEntity<D> getById(@PathVariable("id") ID id) {
        D result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<D> create(@Valid @RequestBody D d) {
        D result = service.create(d);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/update/{id}")
    @Override
    public ResponseEntity<D> update(@PathVariable("id") ID id, @Valid @RequestBody D d) {
        D result = service.update(id, d);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable("id") ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    @Override
    public ResponseEntity<Long> count() {
        Long result = service.count();
        return ResponseEntity.ok(result);
    }

}

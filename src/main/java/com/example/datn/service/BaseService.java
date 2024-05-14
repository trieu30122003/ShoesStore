package com.example.datn.service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T,S> {
    Page<S> getAll(int page, int size);

    T getOne(int id);

    T save(T t);

    T update(T t, int id);

    void delete(int id);

    Page<S> search(String name, int page, int size);
}

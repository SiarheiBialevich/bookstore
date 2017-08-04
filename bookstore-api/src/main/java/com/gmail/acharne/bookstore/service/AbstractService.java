package com.gmail.acharne.bookstore.service;

import com.gmail.acharne.bookstore.entitys.BaseEntity;

import java.util.List;

public interface AbstractService<T extends BaseEntity> {

    void create(T entity);

    T getById(Integer id);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}

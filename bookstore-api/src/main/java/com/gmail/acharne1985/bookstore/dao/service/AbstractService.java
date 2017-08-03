package com.gmail.acharne1985.bookstore.dao.service;

import com.gmail.acharne1985.bookstore.entitys.BaseEntity;

import java.util.List;

public interface AbstractService<T extends BaseEntity> {

    void create(T entity);

    T getById(Integer id);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}

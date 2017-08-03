package com.gmail.acharne.bookstore.dao;

import com.gmail.acharne.bookstore.entitys.BaseEntity;
import org.hibernate.Session;

import java.util.List;

public interface AbstractDao<T extends BaseEntity> {

    void create(T entity, Session session);

    T getById(Integer id, Session session);

    List<T> getAll(Session session);

    void update(T entity, Session session);

    void delete(T entity, Session session);
}
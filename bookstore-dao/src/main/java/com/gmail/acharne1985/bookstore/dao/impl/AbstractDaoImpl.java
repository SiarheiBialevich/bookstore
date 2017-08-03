package com.gmail.acharne1985.bookstore.dao.impl;

import com.gmail.acharne1985.bookstore.dao.AbstractDao;
import com.gmail.acharne1985.bookstore.entitys.BaseEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class AbstractDaoImpl<T extends BaseEntity> implements AbstractDao<T> {

    private Class clazz;

    protected AbstractDaoImpl(Class clazz){
        this.clazz = clazz;
    }

    @Override
    public void create(T entity, Session session) {
        session.save(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getById(Integer id, Session session) {

        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("id", id));

        return (T)criteria.list().get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Session session) {

        Criteria criteria = session.createCriteria(clazz);

        return criteria.list();
    }

    @Override
    public void update(T entity, Session session) {
        session.update(entity);
    }

    @Override
    public void delete(T entity, Session session) {
        session.delete(entity);
    }
}

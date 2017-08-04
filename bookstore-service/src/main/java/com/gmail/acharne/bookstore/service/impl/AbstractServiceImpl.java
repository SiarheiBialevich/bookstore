package com.gmail.acharne.bookstore.service.impl;


import com.gmail.acharne.bookstore.dao.AbstractDao;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.dao.service.AbstractService;
import com.gmail.acharne.bookstore.entitys.BaseEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public abstract class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {

    private static final Logger log = Logger.getLogger(AbstractServiceImpl.class.getName());

    private AbstractDao<T> dao;

    @Override
    public void create(T entity) {
        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getInstance().getSession();
            log.info("session: " + session);
            transaction = session.beginTransaction();

            dao.create(entity, session);

            transaction.commit();

        } catch (Exception e) {

            log.error("Failed to add object to the database", e);

            if (transaction != null) {
                transaction.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public T getById(Integer id) {

        T entityModel = null;

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();

            entityModel = dao.getById(id, session);

            transaction.commit();
        } catch (Exception e) {

            log.error("Failed to getById object to the database", e);

            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return entityModel;
    }

    @Override
    public List<T> getAll() {

        List<T> listEntitys = null;

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getInstance().getSession();
            log.info("session: " + session);
            transaction = session.beginTransaction();

            listEntitys = dao.getAll(session);

            transaction.commit();

        } catch (Exception e) {
            log.error("Failed to getAll object to the database", e);

            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session !=null) {
                session.close();
            }
        }

        return listEntitys;
    }

    @Override
    public void update(T entity) {

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getInstance().getSession();
            log.info("session: " + session);
            transaction = session.beginTransaction();

            dao.update(entity, session);

            transaction.commit();

        } catch (Exception e) {

            log.error("Failed to update object to the database", e);
            if (transaction != null) {
                transaction.rollback();
            }


        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T entity) {

        Session session = null;
        Transaction transaction = null;

        try  {

            session = HibernateUtil.getInstance().getSession();
            log.info("session: "+ session);
            transaction = session.beginTransaction();

            dao.delete(entity, session);

            transaction.commit();

        } catch (Exception e) {

            log.error("Failed to delete object to the database", e);
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

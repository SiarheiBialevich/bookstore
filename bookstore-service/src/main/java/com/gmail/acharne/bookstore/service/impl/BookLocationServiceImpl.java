package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.BookLocationDao;
import com.gmail.acharne.bookstore.dao.impl.BookLocationDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.service.BookLocationService;
import com.gmail.acharne.bookstore.entitys.BookLocation;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class BookLocationServiceImpl implements BookLocationService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class.getName());

    private BookLocationDao bookLocationDao = new BookLocationDaoImpl();

    public void add(BookLocation bookLocation) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            bookLocationDao.create(bookLocation, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding book location", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void update(BookLocation bookLocation) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            bookLocationDao.update(bookLocation, session);
            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error update book locations", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(BookLocation bookLocation) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            bookLocationDao.delete(bookLocation, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error delete book locations", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

}

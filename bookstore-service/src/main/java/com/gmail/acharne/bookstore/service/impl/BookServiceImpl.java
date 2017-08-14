package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.BookDao;
import com.gmail.acharne.bookstore.dao.impl.BookDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.Book;
import com.gmail.acharne.bookstore.service.BookService;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


@SuppressWarnings("ALL")
public class BookServiceImpl implements BookService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class.getName());

    BookDao bookDao = new BookDaoImpl();

    public void add(Book book) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            bookDao.create(book, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding book", e);
            session.getTransaction().rollback();
        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void getAll() {

        List<Book> books = null;
        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            Criteria criteria = session.createCriteria(Book.class);

            books = criteria.list();

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error get all books", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public Book getById(Integer id) {

        Session session = HibernateUtil.getInstance().getSession();

        Criteria criteria = null;

        try {

            session.beginTransaction();

            criteria = session.createCriteria(Book.class);
            criteria.add(Restrictions.eq("id", id));

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error get book by id", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return (Book) criteria.list().get(0);
    }

    public void delete(Book book) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            bookDao.delete(book, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error delete book", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

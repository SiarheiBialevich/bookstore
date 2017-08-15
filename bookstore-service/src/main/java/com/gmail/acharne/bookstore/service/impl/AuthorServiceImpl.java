package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.AuthorDao;
import com.gmail.acharne.bookstore.dao.impl.AuthorDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.Author;
import com.gmail.acharne.bookstore.service.AuthorService;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

@SuppressWarnings("ALL")
public class AuthorServiceImpl implements AuthorService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class.getName());

    private AuthorDao authorDao = new AuthorDaoImpl();

    public void add(Author author) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            authorDao.create(author, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding author", e);
            session.getTransaction().rollback();
        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void getAll() {

        List<Author> authors = null;
        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            Criteria criteria = session.createCriteria(Author.class);

            authors = criteria.list();

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error get all authors", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public Author getById(Integer id) {

        Session session = HibernateUtil.getInstance().getSession();

        Criteria criteria = null;

        try {

            session.beginTransaction();

            criteria = session.createCriteria(Author.class);
            criteria.add(Restrictions.eq("id", id));

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error get author by id", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return (Author) criteria.list().get(0);
    }

    public void delete(Author book) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            authorDao.delete(book, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error delete author", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

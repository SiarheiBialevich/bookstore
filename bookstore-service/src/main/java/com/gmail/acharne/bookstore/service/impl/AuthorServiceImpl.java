package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.Author;
import com.gmail.acharne.bookstore.service.AuthorService;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class.getName());

    //AuthorDao authorDao = new AuthorDaoImpl();

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> getBooksByAuthor() {

        Session session = HibernateUtil.getInstance().getSession();

        List<Author> authors = null;

        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Author.class, "author");
            criteria.createCriteria("Book.authors", "books");
            criteria.setProjection(Projections.distinct(Projections.property("author")));

            authors = criteria.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.info("Error in method call getBooksByAuthor", e);

        } finally {
            session.close();
        }

        return authors;
    }
}

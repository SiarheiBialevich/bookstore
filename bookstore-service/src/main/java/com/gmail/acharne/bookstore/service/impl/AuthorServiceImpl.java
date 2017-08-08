package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.Author;
import com.gmail.acharne.bookstore.service.AuthorService;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

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

            Criteria criteria = session.createCriteria(Author.class, "a");
            criteria.createAlias("books", "b", JoinType.LEFT_OUTER_JOIN)
                    .add(Restrictions.or(
                            Restrictions.eq("a.id", 1),
                            Restrictions.and(
                                    Restrictions.isEmpty("a.books"),
                                    Restrictions.isEmpty("b.authors")

                            )
                    ));

            authors = criteria.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.info("Error in method call getBooksByAuthor", e);
            e.getMessage();

        } finally {
            session.close();
        }

        return authors;
    }
}

package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.AuthorDao;
import com.gmail.acharne.bookstore.dao.impl.AuthorDaoImpl;
import com.gmail.acharne.bookstore.entitys.Author;
import com.gmail.acharne.bookstore.service.AuthorService;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AuthorServiceImpl implements AuthorService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class.getName());

    private AuthorDao authorDao = new AuthorDaoImpl();

    private SessionFactory sessionFactory;

    private Session session;

    @Transactional
    public void add(Author author) {

        session = this.sessionFactory.getCurrentSession();

        authorDao.create(author, session);
    }

    @Transactional
    public void getAll() {

        List<Author> authors = null;
        session = this.sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(Author.class);

        authors = criteria.list();
    }

    @Transactional
    public Author getById(Integer id) {

        session = this.sessionFactory.getCurrentSession();

        Criteria criteria = null;

        criteria = session.createCriteria(Author.class);
        criteria.add(Restrictions.eq("id", id));

        return (Author) criteria.list().get(0);
    }

    @Transactional
    public void delete(Author book) {

        session = this.sessionFactory.getCurrentSession();

        authorDao.delete(book, session);

    }
}

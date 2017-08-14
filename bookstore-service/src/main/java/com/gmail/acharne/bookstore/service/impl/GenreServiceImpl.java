package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.GenreDao;
import com.gmail.acharne.bookstore.dao.impl.GenreDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.Genre;
import com.gmail.acharne.bookstore.service.GenreService;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class GenreServiceImpl implements GenreService {

    private static final Logger log = Logger.getLogger(GenreServiceImpl.class.getName());

    private GenreDao genreDao = new GenreDaoImpl();

    public void add(Genre genre) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            genreDao.create(genre, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding genre", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

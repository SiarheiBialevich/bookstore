package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.GenreDao;
import com.gmail.acharne.bookstore.entitys.Genre;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl extends AbstractDaoImpl<Genre> implements GenreDao {

    private static final Logger log = Logger.getLogger(GenreDaoImpl.class.getName());

    public GenreDaoImpl() {
        super(Genre.class);
    }

    @Override
    public List<Genre> getAllGenresWithBooks(String name, Session session) throws Exception {

        List<Genre> genres = null;

        try {

            Criteria criteria = session.createCriteria(Genre.class);
            criteria.createAlias("books", "books", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("nameGenre", "horror"));

            //noinspection unchecked
            genres = criteria.list();

//            for (Genre genre : genres) {
//
//                Hibernate.initialize(genre.getBooks());
//
//            }
        } catch (Exception e) {

            log.error("Error in dao, get all genres with books method", e);
        }

        return genres;
    }
}

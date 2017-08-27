package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.BookDao;
import com.gmail.acharne.bookstore.entitys.Book;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class BookDaoImpl extends AbstractDaoImpl<Book> implements BookDao {

    private static final Logger log = Logger.getLogger(BookDaoImpl.class.getName());

    public BookDaoImpl() {
        super(Book.class);
    }

    @Override
    public List<Book> getBooksByGenre(String nameGenre, Session session) {

        List<Book> books = null;

        try {
            Criteria criteria = session.createCriteria(Book.class, "book");
            criteria.createAlias("genre", "genre", JoinType.INNER_JOIN);
            criteria.add(Restrictions.eq("genre.nameGenre", nameGenre));

            //noinspection unchecked
            books = criteria.list();

        } catch (Exception e) {
            log.error("Error in DAO, getBooksByGenre", e);
        }

        return books;
    }
}

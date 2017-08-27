package com.gmail.acharne.bookstore.dao;

import com.gmail.acharne.bookstore.entitys.Genre;
import org.hibernate.Session;

import java.util.List;

public interface GenreDao extends AbstractDao<Genre> {

    List<Genre> getAllGenresWithBooks(String name, Session session) throws Exception;

}

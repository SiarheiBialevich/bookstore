package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.GenreDao;
import com.gmail.acharne.bookstore.entitys.Genre;

public class GenreDaoImpl extends AbstractDaoImpl<Genre> implements GenreDao {

    protected GenreDaoImpl(Class clazz) {
        super(clazz);
    }
}

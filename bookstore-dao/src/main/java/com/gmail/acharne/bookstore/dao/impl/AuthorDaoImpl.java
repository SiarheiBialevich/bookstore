package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.AuthorDao;
import com.gmail.acharne.bookstore.entitys.Author;

public class AuthorDaoImpl extends AbstractDaoImpl<Author> implements AuthorDao {

    public AuthorDaoImpl() {
        super(Author.class);
    }
}

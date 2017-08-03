package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.BookLocationDao;
import com.gmail.acharne.bookstore.entitys.BookLocation;

public class BookLocationDaoImpl extends AbstractDaoImpl<BookLocation> implements BookLocationDao {

    protected BookLocationDaoImpl(Class clazz) {
        super(clazz);
    }
}

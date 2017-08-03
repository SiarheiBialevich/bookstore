package com.gmail.acharne1985.bookstore.dao.impl;

import com.gmail.acharne1985.bookstore.dao.AbstractDao;
import com.gmail.acharne1985.bookstore.dao.BookLocationDao;
import com.gmail.acharne1985.bookstore.entitys.BookLocation;

public class BookLocationDaoImpl extends AbstractDaoImpl<BookLocation> implements BookLocationDao {

    protected BookLocationDaoImpl(Class clazz) {
        super(clazz);
    }
}

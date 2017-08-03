package com.gmail.acharne1985.bookstore.dao.impl;

import com.gmail.acharne1985.bookstore.dao.BookDao;
import com.gmail.acharne1985.bookstore.entitys.Book;

public class BookDaoImpl extends AbstractDaoImpl<Book> implements BookDao {

    protected BookDaoImpl(Class clazz) {
        super(clazz);
    }
}

package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.BookLocationDao;
import com.gmail.acharne.bookstore.entitys.BookLocation;
import org.springframework.stereotype.Repository;

@Repository
public class BookLocationDaoImpl extends AbstractDaoImpl<BookLocation> implements BookLocationDao {

    public BookLocationDaoImpl() {
        super(BookLocation.class);
    }
}

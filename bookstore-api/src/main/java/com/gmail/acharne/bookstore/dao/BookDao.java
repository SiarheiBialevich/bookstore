package com.gmail.acharne.bookstore.dao;

import com.gmail.acharne.bookstore.entitys.Book;
import org.hibernate.Session;

import java.util.List;

public interface BookDao extends AbstractDao<Book> {

    List<Book> getBooksByGenre(String nameGenre, Session session);

}

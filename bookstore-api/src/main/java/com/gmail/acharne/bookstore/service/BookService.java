package com.gmail.acharne.bookstore.service;

import com.gmail.acharne.bookstore.entitys.Book;

import java.util.List;

public interface BookService {

    @SuppressWarnings({"unused", "UnnecessaryInterfaceModifier"})
    public List<Book> getBooksByGenre(String nameGenre);

}

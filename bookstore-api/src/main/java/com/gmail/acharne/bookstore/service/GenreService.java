package com.gmail.acharne.bookstore.service;

import com.gmail.acharne.bookstore.entitys.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenresWithBooks(String name);

}

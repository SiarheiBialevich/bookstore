package com.gmail.acharne.bookstore.run;

import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.Book;
import com.gmail.acharne.bookstore.entitys.Genre;
import com.gmail.acharne.bookstore.service.BookService;
import com.gmail.acharne.bookstore.service.GenreService;
import com.gmail.acharne.bookstore.service.impl.BookServiceImpl;
import com.gmail.acharne.bookstore.service.impl.GenreServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class Run {

    private final static Logger log = Logger.getLogger(Run.class.getName());

    public static void main(String[] args) {

        GenreService genreService = new GenreServiceImpl();
        //BookService bookService = new BookServiceImpl();

        List<Genre> genres = genreService.getAllGenresWithBooks("horror");
        for (Genre genre : genres) {
            System.out.println(genre);
            System.out.println(genre.getBooks());
        }


        HibernateUtil.shutdown();
    }
}

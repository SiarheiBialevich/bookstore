package com.gmail.acharne.bookstore.run;

import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.Author;
import com.gmail.acharne.bookstore.service.AuthorService;
import com.gmail.acharne.bookstore.service.impl.AuthorServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class Run {

    private final static Logger log = Logger.getLogger(Run.class.getName());

    public static void main(String[] args) {


        HibernateUtil.shutdown();
    }
}

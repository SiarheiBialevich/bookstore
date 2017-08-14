package com.gmail.acharne.bookstore.run;

import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import org.apache.log4j.Logger;

public class Run {

    private final static Logger log = Logger.getLogger(Run.class.getName());

    public static void main(String[] args) {


        HibernateUtil.shutdown();
    }
}

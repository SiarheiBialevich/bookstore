package com.gmail.acharne.bookstore.run;

import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import org.hibernate.Session;

public class Run {

    public static void main(String[] args) {

        Session session = HibernateUtil.getInstance().getSession();

        System.out.println("start session");

        HibernateUtil.shutdown();
        System.out.println("shutdownsession");
    }
}

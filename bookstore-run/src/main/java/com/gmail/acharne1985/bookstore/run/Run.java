package com.gmail.acharne1985.bookstore.run;

import com.gmail.acharne1985.bookstore.connector.HibernateUtil;
import org.hibernate.SessionFactory;

public class Run {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSession();

        factory.close();
    }
}

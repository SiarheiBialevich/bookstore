package com.gmail.acharne1985.bookstore.connector;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("ALL")
public class HibernateUtility {

    private final static Logger log = Logger.getLogger(HibernateUtility.class.getName());

    public static SessionFactory factory;

    private HibernateUtility() {

    }

    public static synchronized SessionFactory getSessionFactory() {

        try {
            if (factory == null) {
                factory = new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
            }
        } catch (HibernateException e) {
            log.error("Initial SessionFactory creating failed" + e.getMessage());
            e.getMessage();
        }

        return factory;
    }
}

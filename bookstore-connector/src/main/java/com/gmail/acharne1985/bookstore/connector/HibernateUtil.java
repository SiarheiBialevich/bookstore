package com.gmail.acharne1985.bookstore.connector;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("ALL")
public class HibernateUtil {

    private final static Logger log = Logger.getLogger(HibernateUtil.class.getName());

    private static SessionFactory factory;

    private HibernateUtil() {

    }

    private static SessionFactory buildSessionFactory() {
        try {

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            log.info("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            log.info("Hibernate serviceRegistry created");

            factory = configuration.buildSessionFactory(serviceRegistry);

            return factory;
        }
        catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSession() {
        if(factory == null) {
            factory = buildSessionFactory();
        }
        return factory;
    }
}

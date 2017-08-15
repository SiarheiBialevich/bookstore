package com.gmail.acharne.bookstore.dao.impl.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("ALL")
public class HibernateUtil {

    private final static Logger log = Logger.getLogger(HibernateUtil.class.getName());

    private static HibernateUtil hibernateUtil;
    private static SessionFactory factory;

    private HibernateUtil() {

    }

    public static synchronized HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }

        return hibernateUtil;
    }

    public Session getSession() {

        if (factory == null) {
            createFactory();
        }

        return factory.openSession();
    }

    private void createFactory() {
        try {

            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            log.info("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            log.info("Hibernate serviceRegistry created");

            factory = cfg.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}

package com.gmail.acharne.bookstore.dao.impl.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("ALL")
public class HibernateUtil {

    private final static Logger log = Logger.getLogger(HibernateUtil.class.getName());

    private static HibernateUtil instance;
    private Configuration cfg;
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    private HibernateUtil() throws HibernateException {
        try {

            cfg = new Configuration().configure("hibernate.cfg.xml");
            log.info("Hibernate Configuration loaded");

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            log.info("Hibernate serviceRegistry created");

            factory = cfg.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static synchronized HibernateUtil getInstance() throws HibernateException {
        if (instance == null) {
            instance = new HibernateUtil();
        }

        return instance;
    }

    public Session getSession() throws HibernateException {

        Session session = factory.openSession();

        if (!session.isConnected()) {
            this.reconnect();
        }

        return session;
    }

    private void reconnect() throws HibernateException {
        this.factory = cfg.buildSessionFactory(serviceRegistry);
    }

    public static void shutdown() {
        if (serviceRegistry != null) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
}

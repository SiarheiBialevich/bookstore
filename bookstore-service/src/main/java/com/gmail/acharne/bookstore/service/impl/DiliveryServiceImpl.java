package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.DiliveryDao;
import com.gmail.acharne.bookstore.dao.impl.DiliveryDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.service.DiliveryService;
import com.gmail.acharne.bookstore.entitys.Dilivery;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class DiliveryServiceImpl implements DiliveryService {

    private static final Logger log = Logger.getLogger(DiliveryServiceImpl.class.getName());

    private DiliveryDao diliveryDao = new DiliveryDaoImpl();

    public void add(Dilivery dilivery) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            diliveryDao.create(dilivery, session);
            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding dilivery", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

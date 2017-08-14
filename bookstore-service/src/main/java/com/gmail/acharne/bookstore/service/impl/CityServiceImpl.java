package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.CityDao;
import com.gmail.acharne.bookstore.dao.impl.CityDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.service.CityService;
import com.gmail.acharne.bookstore.entitys.City;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class CityServiceImpl implements CityService {

    private static final Logger log = Logger.getLogger(CityServiceImpl.class.getName());

    private CityDao cityDao = new CityDaoImpl();

    public void add(City city) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            cityDao.create(city, session);
            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding city", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

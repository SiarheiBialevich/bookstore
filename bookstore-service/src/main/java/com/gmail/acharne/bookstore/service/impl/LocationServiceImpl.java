package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.LocationDao;
import com.gmail.acharne.bookstore.dao.impl.LocationDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.service.LocationService;
import com.gmail.acharne.bookstore.entitys.Location;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class LocationServiceImpl implements LocationService {

    private static final Logger log = Logger.getLogger(LocationServiceImpl.class.getName());

    private LocationDao locationDao = new LocationDaoImpl();

    public void add(Location location) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            locationDao.create(location, session);
            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding location", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

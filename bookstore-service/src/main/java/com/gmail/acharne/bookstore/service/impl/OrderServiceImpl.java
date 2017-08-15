package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.OrderDao;
import com.gmail.acharne.bookstore.dao.impl.OrderDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.service.OrderService;
import com.gmail.acharne.bookstore.entitys.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class OrderServiceImpl implements OrderService {

    private static final Logger log = Logger.getLogger(OrderServiceImpl.class.getName());

    private OrderDao orderDao = new OrderDaoImpl();

    public void add(Order order) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            orderDao.create(order, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding order", e);
            session.getTransaction().rollback();
        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Order order) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            orderDao.update(order, session);
            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error update order", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Order order) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            orderDao.delete(order, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error delete order", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

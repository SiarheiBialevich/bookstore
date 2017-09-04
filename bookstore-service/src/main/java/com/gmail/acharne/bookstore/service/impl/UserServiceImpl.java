package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.UserDao;
import com.gmail.acharne.bookstore.dao.impl.UserDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.entitys.User;
import com.gmail.acharne.bookstore.service.UserService;
import org.apache.log4j.Logger;
import org.hibernate.Session;

@SuppressWarnings("ALL")
public class UserServiceImpl implements UserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());

    private UserDao userDao = new UserDaoImpl();

    public void add(User user) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            userDao.create(user, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding user", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

}

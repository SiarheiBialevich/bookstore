package com.gmail.acharne.bookstore.service.impl;

import com.gmail.acharne.bookstore.dao.RoleDao;
import com.gmail.acharne.bookstore.dao.impl.RoleDaoImpl;
import com.gmail.acharne.bookstore.dao.impl.util.HibernateUtil;
import com.gmail.acharne.bookstore.service.RoleService;
import com.gmail.acharne.bookstore.entitys.Role;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class RoleServiceImpl implements RoleService {

    private static final Logger log = Logger.getLogger(RoleServiceImpl.class.getName());

    private RoleDao roleDao = new RoleDaoImpl();

    public void add(Role role) {

        Session session = HibernateUtil.getInstance().getSession();

        try {

            session.beginTransaction();

            roleDao.create(role, session);

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Error adding role", e);
            session.getTransaction().rollback();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}

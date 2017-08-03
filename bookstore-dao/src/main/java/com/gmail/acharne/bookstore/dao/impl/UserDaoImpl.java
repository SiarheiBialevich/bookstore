package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.UserDao;
import com.gmail.acharne.bookstore.entitys.User;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    protected UserDaoImpl(Class clazz) {
        super(clazz);
    }
}

package com.gmail.acharne1985.bookstore.dao.impl;

import com.gmail.acharne1985.bookstore.dao.UserDao;
import com.gmail.acharne1985.bookstore.entitys.User;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    protected UserDaoImpl(Class clazz) {
        super(clazz);
    }
}

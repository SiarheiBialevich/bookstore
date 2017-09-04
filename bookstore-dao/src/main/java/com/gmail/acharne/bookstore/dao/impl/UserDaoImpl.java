package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.UserDao;
import com.gmail.acharne.bookstore.entitys.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }
}

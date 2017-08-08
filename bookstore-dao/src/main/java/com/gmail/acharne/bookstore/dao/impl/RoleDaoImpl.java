package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.RoleDao;
import com.gmail.acharne.bookstore.entitys.Role;

public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

    protected RoleDaoImpl() {
        super(Role.class);
    }
}

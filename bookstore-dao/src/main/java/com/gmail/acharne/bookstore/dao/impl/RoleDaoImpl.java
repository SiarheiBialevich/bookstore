package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.RoleDao;
import com.gmail.acharne.bookstore.entitys.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }
}

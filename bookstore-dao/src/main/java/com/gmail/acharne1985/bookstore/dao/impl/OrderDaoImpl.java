package com.gmail.acharne1985.bookstore.dao.impl;

import com.gmail.acharne1985.bookstore.dao.OrderDao;
import com.gmail.acharne1985.bookstore.entitys.Order;

public class OrderDaoImpl extends AbstractDaoImpl<Order> implements OrderDao {

    protected OrderDaoImpl(Class clazz) {
        super(clazz);
    }
}

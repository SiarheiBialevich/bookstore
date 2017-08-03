package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.OrderDao;
import com.gmail.acharne.bookstore.entitys.Order;

public class OrderDaoImpl extends AbstractDaoImpl<Order> implements OrderDao {

    protected OrderDaoImpl(Class clazz) {
        super(clazz);
    }
}

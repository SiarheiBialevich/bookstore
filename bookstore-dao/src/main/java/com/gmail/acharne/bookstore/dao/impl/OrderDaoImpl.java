package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.OrderDao;
import com.gmail.acharne.bookstore.entitys.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDaoImpl<Order> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }
}

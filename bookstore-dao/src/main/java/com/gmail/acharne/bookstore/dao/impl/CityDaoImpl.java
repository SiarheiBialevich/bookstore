package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.CityDao;
import com.gmail.acharne.bookstore.entitys.City;

public class CityDaoImpl extends AbstractDaoImpl<City> implements CityDao {

    public CityDaoImpl() {
        super(City.class);
    }
}

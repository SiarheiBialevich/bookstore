package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.CityDao;
import com.gmail.acharne.bookstore.entitys.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl extends AbstractDaoImpl<City> implements CityDao {

    public CityDaoImpl() {
        super(City.class);
    }
}

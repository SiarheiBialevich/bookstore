package com.gmail.acharne.bookstore.dao.impl;

import com.gmail.acharne.bookstore.dao.LocationDao;
import com.gmail.acharne.bookstore.entitys.Location;

public class LocationDaoImpl extends AbstractDaoImpl<Location> implements LocationDao {

    public LocationDaoImpl() {
        super(Location.class);
    }
}

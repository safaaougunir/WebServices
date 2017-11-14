package com.test.demo.DAO;

import com.test.demo.Models.Room;

import javax.persistence.TypedQuery;

public interface RoomDaoCustom {
    public TypedQuery<Room> switchLight(long id);
}

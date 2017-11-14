package com.test.demo.DAO;

import com.test.demo.Models.Light;
import com.test.demo.Models.Room;

import javax.persistence.TypedQuery;
import java.util.List;

public interface RoomDaoCustom  {
    public List<Room> findRoomsWithOnLight();
}

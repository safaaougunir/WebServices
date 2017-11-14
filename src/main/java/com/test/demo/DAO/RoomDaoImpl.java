package com.test.demo.DAO;

import com.test.demo.Models.Light;
import com.test.demo.Models.Room;
import com.test.demo.Models.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoomDaoImpl implements RoomDaoCustom{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Room> findRoomsWithOnLight() {
        String jpql = "select rm from Room rm where rm.light.status = :value";

        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.ON)
                .getResultList();

    }
}

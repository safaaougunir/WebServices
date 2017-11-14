package com.test.demo.DAO;

import com.test.demo.Models.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class RoomDaoImpl implements RoomDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public TypedQuery<Room> switchLight(long id){

            String jpql = "update lt from Light lt,Room rm where rm.light_id= lt.id and rm.id = :value";
            TypedQuery<Room> query = em.createQuery(jpql, Room.class);
            return query.setParameter("value", id);
        }


}

package com.test.demo.DAO;

import com.test.demo.Models.Light;
import com.test.demo.Models.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class LightDaoImpl implements LightDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Light> findOnLights() {
        String jpql = "select lt from Light lt where lt.status = :value";
        TypedQuery<Light> query = em.createQuery(jpql, Light.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }
}

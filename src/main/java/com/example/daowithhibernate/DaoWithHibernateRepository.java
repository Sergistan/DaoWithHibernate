package com.example.daowithhibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoWithHibernateRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
       return entityManager.createQuery("select p from Person p where p.cityOfLiving = " +
                       ":city order by p.cityOfLiving", Person.class)
               .setParameter("city", city)
               .getResultList();
    }

}

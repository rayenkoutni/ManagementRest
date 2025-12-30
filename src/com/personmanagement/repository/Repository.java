package com.personmanagement.repository;

import com.personmanagement.entities.Person;

import javax.persistence.*;
import java.util.List;

public class Repository {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPU");

    public List<Person> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Person> list = em.createQuery("from Person", Person.class).getResultList();
        em.close();
        return list;
    }

    public Person findById(int id) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        em.close();
        return p;
    }

    public void save(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        if (p != null)
            em.remove(p);
        em.getTransaction().commit();
        em.close();
    }
}
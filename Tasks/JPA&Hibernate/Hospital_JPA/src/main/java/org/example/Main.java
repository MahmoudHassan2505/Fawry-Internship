package org.example;



import org.example.Entity.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Hospital hospital = new Hospital();
        hospital.setId(1l);
        hospital.setName("Hospital 2");
        entityManager.persist(hospital);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
package org.example.repositoryies;

import org.example.Entity.Hospital;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;


import java.util.List;

public class HospitalRepository {
    public Hospital get(int id){
        Session session = null;
        Hospital hospital;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            hospital = session.get(Hospital.class,id);
            session.getTransaction().commit();
            return hospital;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    public List<Hospital> findAll(){
        Session session = null;
        List<Hospital> hospitals;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            hospitals = session.createQuery("from Hospital").getResultList();
            session.getTransaction().commit();
            return hospitals;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    public void insert(Hospital hospital){
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(hospital);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}

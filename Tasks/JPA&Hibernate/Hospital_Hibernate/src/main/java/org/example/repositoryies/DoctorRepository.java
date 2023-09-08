package org.example.repositoryies;
import org.example.Entity.Doctor;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class DoctorRepository {


    public Doctor get(int id) {
        Session session = null;
        Doctor doctor;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            doctor = session.get(Doctor.class, id);
            session.getTransaction().commit();
            return doctor;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public List<Doctor> findAll() {
        Session session = null;
        List<Doctor> doctors;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            doctors = session.createQuery("from Doctor ").getResultList();
            session.getTransaction().commit();
            return doctors;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public void insert(Doctor doctor) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}



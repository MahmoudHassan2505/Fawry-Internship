package org.example.repositoryies;
import org.example.Entity.Patient;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;


import java.util.List;

public class PatientRepository {


    public Patient get(int id) {
        Session session = null;
        Patient patient;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            patient = session.get(Patient.class, id);
            session.getTransaction().commit();
            return patient;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public List<Patient> findAll() {
        Session session = null;
        List<Patient> patients;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            patients = session.createQuery("from Patient").getResultList();
            session.getTransaction().commit();
            return patients;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public void insert(Patient patient) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }


}

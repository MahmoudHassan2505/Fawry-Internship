package org.example.repositoryies;
import org.example.Entity.Drug;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;


import java.util.List;

public class DrugRepository {


    public Drug get(int id) {
        Session session = null;
        Drug drug;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            drug = session.get(Drug.class, id);
            session.getTransaction().commit();
            return drug;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public List<Drug> findAll() {
        Session session = null;
        List<Drug> drugs;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            drugs = session.createQuery("from Drug ").getResultList();
            session.getTransaction().commit();
            return drugs;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public void insert(Drug drug) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(drug);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }


}

package org.example.utils;

import org.example.Entity.Hospital;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            synchronized (HibernateUtils.class){
                if(sessionFactory==null)
                    sessionFactory= new Configuration().configure("hibernate.cfg.xml")
                            .buildSessionFactory();
            }
        }
        return sessionFactory;
    }
    }


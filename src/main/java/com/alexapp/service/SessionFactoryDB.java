package com.alexapp.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Create SessionFactory and return session!
public class SessionFactoryDB {

    private static final SessionFactory session = sessionFactory();

    private static SessionFactory sessionFactory() {

        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("SessionFactory creation failed");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSession() {
        return session;
    }
}

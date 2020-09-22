package com.alexapp.service;

import com.alexapp.dao.UserDAO;
import com.alexapp.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

// DB Service class, layer between controller and database!
public class PoolService implements UserDAO {

    private final Session session = SessionFactoryDB.getSession().openSession();
    private Transaction tx;

    @Override
    public boolean addUser(String login, String password, String email) {
        boolean statusRegistration = false;
        if (tx == null) tx = session.beginTransaction();


        try {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            System.out.println(user.toString());
            session.save(user);
            tx.commit();
            statusRegistration = true;

        } catch (ConstraintViolationException e) {
            tx.setRollbackOnly();
        }
        return statusRegistration;
    }

    @Override
    public boolean logInUser(String email, String password) {
        boolean authorizationControl = false;
        //if (transaction == null) session.beginTransaction();
        String getUserPassword = "SELECT password FROM User WHERE email = '" + email + "'";
        try {
            Query query = session.createNativeQuery(getUserPassword);
            String passwordUser = (String) query.getSingleResult();
            if (password.equals(passwordUser)) authorizationControl = true;

        } catch (NoResultException ignore) {

        }
        return authorizationControl;
    }

    //Don't forgot close the session in Controllers class!
    public void shutdownSession() {
        session.close();
    }

}
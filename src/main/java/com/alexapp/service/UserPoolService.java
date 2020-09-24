package com.alexapp.service;

import com.alexapp.dao.UserDAO;
import com.alexapp.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

// DB Service class, layer between controller and database!
public class UserPoolService implements UserDAO {

    private final Session session = SessionFactoryDB.getSession().openSession();
    private Transaction transaction;

    @Override
    public boolean addUser(String login, String password, String email) {
        boolean statusRegistration = false;
        if (transaction == null) transaction = session.beginTransaction();

        try {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            session.save(user);
            transaction.commit();
            statusRegistration = true;

        } catch (ConstraintViolationException e) {
            transaction.setRollbackOnly();
        }
        return statusRegistration;
    }

    // Method selects password by user email and compares him, if all ok - return true. If not - false.
    // If there are no matches in the database, return authorizationControl = false. Ignored DB exception - NoResultException.
    @Override
    public boolean logInUser(String email, String password) {
        boolean authorizationControl = false;
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
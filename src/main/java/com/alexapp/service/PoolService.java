package com.alexapp.service;

import com.alexapp.dao.UserDAO;
import com.alexapp.entity.User;
import org.hibernate.Session;

// DB Service class, layer between controller and database!
public class PoolService implements UserDAO {

    private final Session session = SessionFactoryDB.getSession().openSession();

    @Override
    public void addUser(String login, String password, String email) {

        session.beginTransaction();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        System.out.println(user.toString());
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int updateUser(User user) {
        session.beginTransaction();
        return 0;
    }


}
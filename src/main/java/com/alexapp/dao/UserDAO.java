package com.alexapp.dao;

import java.sql.SQLException;

public interface UserDAO {

    boolean addUser(String name, String password, String email) throws SQLException;

    boolean logInUser(String email, String password) throws SQLException;
}
